package org.example.projectproposalservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.projectproposalservice.dto.ProposalDTO;
import org.example.projectproposalservice.model.Proposal;
import org.example.projectproposalservice.service.ProposalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposals")
@RequiredArgsConstructor
@Tag(name = "Proposal Management", description = "Endpoints for submitting, reviewing, and managing proposals")
public class ProposalController {

    private final ProposalService proposalService;

    @Operation(summary = "Submit Proposal", description = "Submit a proposal for a specific project")
    @PostMapping
    public ResponseEntity<Proposal> submitProposal(@RequestBody ProposalDTO dto) {
        return ResponseEntity.ok(proposalService.submitProposal(dto));
    }

    @Operation(summary = "List Proposals by Project", description = "Fetch all proposals submitted for a given project ID")
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Proposal>> getProposalsByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(proposalService.getProposalsByProject(projectId));
    }

    @Operation(summary = "Accept Proposal", description = "Accept a specific proposal for a project")
    @PatchMapping("/{proposalId}/accept")
    public ResponseEntity<Proposal> acceptProposal(@PathVariable Long proposalId) {
        return ResponseEntity.ok(proposalService.acceptProposal(proposalId));
    }

    @Operation(summary = "Reject Proposal", description = "Reject a specific proposal for a project")
    @PatchMapping("/{proposalId}/reject")
    public ResponseEntity<Proposal> rejectProposal(@PathVariable Long proposalId) {
        return ResponseEntity.ok(proposalService.rejectProposal(proposalId));
    }
}
