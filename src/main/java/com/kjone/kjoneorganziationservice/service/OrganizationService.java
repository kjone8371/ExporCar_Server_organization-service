package com.kjone.kjoneorganziationservice.service;



import com.kjone.kjoneorganziationservice.domain.organization_user.LoginRequest;
import com.kjone.kjoneorganziationservice.domain.organization_user.Organization_User;
import com.kjone.kjoneorganziationservice.domain.request.SignRequest;
import com.kjone.kjoneorganziationservice.domain.response.SignResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface OrganizationService {
    public boolean Organization_signUp(SignRequest signRequest) throws Exception;
    public SignResponse Organization_signIn(LoginRequest loginRequest) throws Exception;
    public void logout(HttpServletResponse response);
    public Organization_User findByOrgEmail(String email);
    public void deleteOrgByEmail(String email) throws Exception; // 사용자 삭제 메서드 정의
    public List<Organization_User> getAllUsers();
    Organization_User createProfile(Long id, SignRequest signRequest) throws Exception;
    Organization_User updateProfile(Long id, SignRequest signRequest) throws Exception;

      // organization 생성/ 관리

}
