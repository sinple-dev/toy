package com.example.toy.common.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {

    @Id
    @Column(unique = true, name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String password;

    @Column
    private String name;

    @Column
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserRoles> userRoles;

    @Column
    private Date createdDt;

    @Column
    private Long updatedBy;

    @Column
    private Date updatedDt;

    @Column
    private Long deletedBy;

    @Column
    private Date deletedDt;

    @Column
    private Boolean deleted;

}
