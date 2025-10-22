package org.example.projectproposalservice.service;

import lombok.RequiredArgsConstructor;
import org.example.projectproposalservice.dto.ProjectDTO;
import org.example.projectproposalservice.exception.ResourceNotFoundException;
import org.example.projectproposalservice.model.Project;
import org.example.projectproposalservice.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final WebClientService webClientService;

    @Override
    public Project createProject(ProjectDTO dto) {
        Project project = Project.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .budget(dto.getBudget())
                .clientId(dto.getClientId())
                .build();

        Project saved = projectRepository.save(project);

        // Example: Notify another service asynchronously
        webClientService.post("/notifications/project-created", saved, Void.class)
                .subscribe(); // fire-and-forget

        return saved;
    }
    @Override
    public Page<Project> listProjects(int page, int size) {
        return projectRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Project getProjectDetails(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
    }

}
