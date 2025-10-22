package org.example.projectproposalservice.repository;

import org.example.projectproposalservice.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByProjectId(Long projectId);
    List<Proposal> findByFreelancerId(Long freelancerId);
    @Query("SELECT p.freelancerId FROM Proposal p WHERE p.status = 'ACCEPTED' GROUP BY p.freelancerId ORDER BY COUNT(p) DESC LIMIT 5")
    List<Long> findTopFreelancers();
}