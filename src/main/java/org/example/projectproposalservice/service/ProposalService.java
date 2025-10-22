package org.example.projectproposalservice.service;
import org.example.projectproposalservice.dto.ProposalDTO;
import org.example.projectproposalservice.model.Proposal;
import java.util.List;

public interface ProposalService { Proposal submitProposal(ProposalDTO dto); List<Proposal> getProposalsByProject(Long projectId); Proposal acceptProposal(Long proposalId); Proposal rejectProposal(Long proposalId); }