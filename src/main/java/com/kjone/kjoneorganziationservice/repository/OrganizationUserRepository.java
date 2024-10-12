package com.kjone.kjoneorganziationservice.repository;

import com.kjone.kjoneorganziationservice.domain.organization_user.Organization_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationUserRepository extends JpaRepository<Organization_User, Long> {
    Optional<Organization_User> findByEmail(String email);

    Optional<Organization_User> findById(Long id);
}
