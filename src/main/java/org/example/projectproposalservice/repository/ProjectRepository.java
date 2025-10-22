package org.example.projectproposalservice.repository;

import org.example.projectproposalservice.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findByClientId(Long clientId, Pageable pageable);
    List<Project> findTop5ByOrderByCreatedAtDesc();

}