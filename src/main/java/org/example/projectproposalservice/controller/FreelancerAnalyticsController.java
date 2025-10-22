package org.example.projectproposalservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.projectproposalservice.model.Project;
import org.example.projectproposalservice.repository.ProjectRepository;
import org.example.projectproposalservice.repository.ProposalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/freelancers")
@RequiredArgsConstructor
@Tag(name = "Freelancer Analytics", description = "Endpoints providing insights and project listings for freelancers")
public class FreelancerAnalyticsController {

    private final ProposalRepository proposalRepository;
    private final ProjectRepository projectRepository;

    @Operation(summary = "Top Freelancers", description = "Fetch top freelancers based on number of accepted proposals")
    @GetMapping("/top")
    public List<Long> getTopFreelancers() {
        // Example logic: aggregate accepted proposals and return freelancer IDs
        return proposalRepository.findTopFreelancers();
    }

    @Operation(summary = "Recent Projects", description = "Fetch the most recently created projects for freelancers to view")
    @GetMapping("/projects/recent")
    public List<Project> getRecentProjects() {
        return projectRepository.findTop5ByOrderByCreatedAtDesc();
    }
}
