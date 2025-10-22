package org.example.projectproposalservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.projectproposalservice.dto.ProjectDTO;
import org.example.projectproposalservice.model.Project;
import org.example.projectproposalservice.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@Tag(name = "Project Management", description = "Endpoints for creating, listing, and viewing project details")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "Create Project", description = "Create a new project proposal by the client")
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody @Valid ProjectDTO dto) {
        return ResponseEntity.ok(projectService.createProject(dto));
    }

    @Operation(summary = "List Projects", description = "Get paginated list of all available projects")
    @GetMapping
    public ResponseEntity<Page<Project>> listProjects(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(projectService.listProjects(page, size));
    }

    @Operation(summary = "Get Project Details", description = "Fetch detailed information of a specific project by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectDetails(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectDetails(id));
    }
}
