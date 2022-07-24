package com.example.toy.common.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class RolesPrivilege {

    @Id
    private Long role;

    @Column
    private Long privilege;

}
