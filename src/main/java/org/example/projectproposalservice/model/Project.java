package org.example.projectproposalservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.projectproposalservice.contants.ProjectStatus;


@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project extends BaseEntity {
    private String title;
    @Column(length = 4000)
    private String description;
    private Double budget;
    private Long clientId;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.OPEN;
}