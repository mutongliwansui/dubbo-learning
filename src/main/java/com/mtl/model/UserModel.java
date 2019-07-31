package com.mtl.model;

import lombok.*;

import java.io.Serializable;


/**
 * @author mtl
 * @Description: 用户信息
 * @date 2019/7/31 18:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class UserModel implements Serializable {
    private int userid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
}
