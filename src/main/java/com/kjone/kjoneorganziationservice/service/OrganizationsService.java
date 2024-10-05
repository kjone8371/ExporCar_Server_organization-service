package com.kjone.kjoneorganziationservice.service;

import com.kjone.kjoneorganziationservice.domain.organization.Organization;

public interface OrganizationsService {
    // organization 생성/ 관리

    public void createOrganization(Organization organization, String sender) throws Exception;
    public Organization getOrganizationName(String name, String sender) throws Exception;

}
