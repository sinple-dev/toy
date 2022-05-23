package com.example.toy.common.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "ROLE_ID")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String roleName;

    @OneToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UsersRoles> usersRoles;

}
