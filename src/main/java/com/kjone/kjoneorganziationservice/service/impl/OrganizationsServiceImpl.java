package com.kjone.kjoneorganziationservice.service.impl;

import com.kjone.kjoneorganziationservice.domain.organization.Organization;
import com.kjone.kjoneorganziationservice.domain.organization_user.Organization_User;
import com.kjone.kjoneorganziationservice.exception.GlobalException;
import com.kjone.kjoneorganziationservice.repository.OrganizationRepository;
import com.kjone.kjoneorganziationservice.repository.OrganizationUserRepository;
import com.kjone.kjoneorganziationservice.service.OrganizationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationsServiceImpl implements OrganizationsService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationUserRepository organizationUserRepository;

    // 조직 생성 관리
    @Override
    @Transactional(rollbackFor = {GlobalException.class})
    public void createOrganization(Organization organization, String sender) {
        // 조직 사용자 확인
        Organization_User user = organizationUserRepository.findByEmail(sender)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // 사용자 권한 확인
        verifyUserPermissions(user);

        // 조직 이름 유효성 검사
        if (organization.getName().length() < 3) {
            throw new GlobalException(HttpStatus.BAD_REQUEST, "조직명은 2자 이상이어야 합니다.");
        } else if (organization.getName().length() > 50) {
            throw new GlobalException(HttpStatus.BAD_REQUEST, "조직명은 50자를 넘길 수 없습니다.");
        }

        // 조직 생성
        Organization newOrganization = Organization.builder()
                .name(organization.getName()) // 조직 이름 설정
                .owner_id(user) // 조직자 설정
                .build();
        organizationRepository.save(newOrganization);

        // 조직 생성 성공 메시지 로그 또는 처리
        System.out.println("조직이 성공적으로 생성되었습니다.");
    }

    // 사용자 권한 확인 메서드
    private void verifyUserPermissions(Organization_User user) {
        if (!user.isOwner()) {
            throw new GlobalException(HttpStatus.FORBIDDEN, "조직 생성 권한이 없습니다.");
        }
    }

    // 조직 이름으로 조직 조회하기
    @Override
    public Organization getOrganizationName(String name, String sender) throws Exception {
        // 조직 사용자 확인
        Organization_User organizationUser = organizationUserRepository.findByEmail(sender)
                .orElseThrow(() -> new RuntimeException("조직자를 찾을 수 없습니다."));

        // 사용자 권한 확인
        if (!organizationUser.isOwner()) {
            throw new GlobalException(HttpStatus.FORBIDDEN, "조직자의 권한이 없습니다.");
        }

        return (Organization) organizationRepository.findByName(name).stream()
                .map(organization -> new Organization(
                        organization.getId(),
                        organization.getName(),
                        organization.getOwner_id(),
                        organization.getCreateTime(),
                        organization.getUpdateTime()
                ))
                .collect(Collectors.toList());
    }
}
