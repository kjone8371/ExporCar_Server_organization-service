package com.kjone.kjoneorganziationservice.domain.organization;


import com.kjone.kjoneorganziationservice.domain.organization_user.Organization_User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "organization")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    // 조직자와의 1:1 관계 설정
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", unique = true, nullable = false)
    private Organization_User owner_id;

    //가입날짜
    @CreationTimestamp
    private LocalDateTime createTime = LocalDateTime.now();

    // 업데이트 날짜
    @UpdateTimestamp
    private LocalDateTime updateTime = LocalDateTime.now();

}
