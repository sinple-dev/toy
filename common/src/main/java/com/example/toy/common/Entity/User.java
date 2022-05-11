package com.example.toy.common.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {

    @Id
    @Column(unique = true)
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
    private String roles;

    @Column
    private String permissions;

    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }

        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }

        return new ArrayList<>();
    }


}
