package org.example.projectproposalservice.service;

import org.example.projectproposalservice.dto.ProjectDTO;
import org.example.projectproposalservice.model.Project;
import org.springframework.data.domain.Page;

public interface ProjectService {
    Project createProject(ProjectDTO dto);
    Page<Project> listProjects(int page, int size);
    Project getProjectDetails(Long id);
}