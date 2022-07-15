package com.hashkart.user.common;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginUser {

    private String username;

    private String password;

}
