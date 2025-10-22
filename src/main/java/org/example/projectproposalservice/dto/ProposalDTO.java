package org.example.projectproposalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectproposalservice.contants.ProposalAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProposalDTO {
    private Long id;
    private Long projectId;
    private Long freelancerId;
    private String coverLetter;
    private Double bidAmount;
    private ProposalAction status;
}
