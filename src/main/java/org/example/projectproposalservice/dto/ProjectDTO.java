package org.example.projectproposalservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO {
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Budget is mandatory")
    @Positive(message = "Budget must be a positive value")
    private Double budget;

    @NotNull(message = "Client ID is mandatory")
    @Positive(message = "Client ID must be a positive value")
    private Long clientId;
}