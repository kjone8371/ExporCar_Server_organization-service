package com.kjone.kjoneorganziationservice.controller;


import com.kjone.kjoneorganziationservice.domain.organization.Organization;
import com.kjone.kjoneorganziationservice.repository.OrganizationRepository;
import com.kjone.kjoneorganziationservice.service.OrganizationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 조직도 생성/관리
@RestController
@RequestMapping("/v1/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationsService organizationService;
    private final OrganizationRepository organizationRepository;

    // 조직 생성 엔드포인트
//    @PostMapping("/create")
//    public ResponseEntity<String> createOrganization(
//            @RequestBody Organization organization,
//            @AuthenticationPrincipal UserDetails userDetails) { // 현재 인증된 사용자 정보 가져오기
//        String senderEmail = userDetails.getUsername(); // 사용자 이메일 추출
//        try {
//            organizationService.createOrganization(organization, senderEmail);
//            return ResponseEntity.status(HttpStatus.CREATED).body("조직이 성공적으로 생성되었습니다.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
    // 조직 생성 엔드포인트
    @PostMapping("/create")
    public ResponseEntity<String> createOrganization(@RequestBody Organization organization, @RequestParam String sender) {
        try {
            organizationService.createOrganization(organization, sender);
            return ResponseEntity.status(HttpStatus.CREATED).body("조직이 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    // 조직 이름으로 조직 조회 엔드포인트
    @GetMapping("/{name}")
    public ResponseEntity<Organization> getOrganization(@PathVariable String name, @RequestParam String sender) {
        try {
            Organization organization = organizationService.getOrganizationName(name, sender);
            return ResponseEntity.ok(organization);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
