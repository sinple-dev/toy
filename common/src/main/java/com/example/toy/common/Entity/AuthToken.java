package com.example.toy.common.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class AuthToken {

    @Id
    @Column(unique = true)
    private Long userId;

    @Column
    @NonNull
    private String accessToken;

    @Column
    @NonNull
    private String refreshToken;

}
