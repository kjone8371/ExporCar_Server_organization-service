package com.kjone.kjoneorganziationservice.domain.response;



import com.kjone.kjoneorganziationservice.domain.organization_user.Organization_User;
import com.kjone.kjoneorganziationservice.domain.role.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {
    private Long id;
    private String email;
    private String password;
    private String name; // 유저 이름
    private int age; // 나이
    private int phone;
    private Long image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Set<Authority> roles;

    public SignResponse(Organization_User organization_user) {
        this.id = organization_user.getId();
        this.email = organization_user.getEmail();
        this.password = organization_user.getPassword();
        this.name = organization_user.getName();
        this.age = organization_user.getAge();
        this.phone = organization_user.getPhone();
        this.image = organization_user.getImage();
        this.createTime = organization_user.getCreateTime();
        this.updateTime = organization_user.getUpdateTime();
        this.roles = organization_user.getRoles();
    }

}

