package com.hashkart.user.common;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginUser {

    private String userName;

    private String password;

}
