package org.example.projectproposalservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.projectproposalservice.contants.ProposalStatus;

@Entity
@Table(name = "proposals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proposal extends BaseEntity {
    private Long projectId;
    private Long freelancerId;

    @Column(length = 5000)
    private String coverLetter;
    private Double bidAmount;

    @Enumerated(EnumType.STRING)
    private ProposalStatus status = ProposalStatus.PENDING;
}