package com.kjone.kjoneorganziationservice.domain.organization;


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


    @Column(name = "owner_id")
    @JoinColumn(name = "owner_id")
    private Long ownerId;

    //가입날짜
    @CreationTimestamp
    private LocalDateTime createTime = LocalDateTime.now();

    // 업데이트 날짜
    @UpdateTimestamp
    private LocalDateTime updateTime = LocalDateTime.now();

}
