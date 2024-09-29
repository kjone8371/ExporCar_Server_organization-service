package com.kjone.kjoneorganziationservice.repository;

import com.kjone.kjoneorganziationservice.domain.organization.Organization;
import com.kjone.kjoneorganziationservice.domain.organization_user.Organization_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Optional<Organization> findByEmail(String email);
}
