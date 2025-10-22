package org.example.projectproposalservice.service;

import lombok.RequiredArgsConstructor;
import org.example.projectproposalservice.dto.ProposalDTO;
import org.example.projectproposalservice.exception.ResourceNotFoundException;
import org.example.projectproposalservice.model.Proposal;
import org.example.projectproposalservice.contants.ProposalStatus;
import org.example.projectproposalservice.repository.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;
    private final WebClientService webClientService;

    @Override
    public Proposal submitProposal(ProposalDTO dto) {
        Proposal proposal = Proposal.builder()
                .projectId(dto.getProjectId())
                .freelancerId(dto.getFreelancerId())
                .coverLetter(dto.getCoverLetter())
                .bidAmount(dto.getBidAmount())
                .status(ProposalStatus.PENDING)
                .build();

        Proposal saved = proposalRepository.save(proposal);

        // Example: Notify client or project service about new proposal
        webClientService.post("/projects/" + saved.getProjectId() + "/proposals", saved, Void.class)
                .subscribe();

        return saved;
    }

    @Override
    public List<Proposal> getProposalsByProject(Long projectId) {
        return proposalRepository.findByProjectId(projectId);
    }

    @Override
    public Proposal acceptProposal(Long proposalId) {
        Proposal proposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> new ResourceNotFoundException("Proposal not found: " + proposalId));
        proposal.setStatus(ProposalStatus.ACCEPTED);
        Proposal saved = proposalRepository.save(proposal);

        webClientService.post("/notifications/proposal-accepted", saved, Void.class)
                .subscribe();

        return saved;
    }

    @Override
    public Proposal rejectProposal(Long proposalId) {
        Proposal proposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> new ResourceNotFoundException("Proposal not found: " + proposalId));
        proposal.setStatus(ProposalStatus.REJECTED);
        Proposal saved = proposalRepository.save(proposal);

        webClientService.post("/notifications/proposal-rejected", saved, Void.class)
                .subscribe();

        return saved;
    }
}
