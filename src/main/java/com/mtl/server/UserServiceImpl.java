package com.mtl.server;

import com.mtl.model.UserModel;

/**
 * @author mtl
 * @Description: 用户信息服务实现
 * @date 2019/7/31 18:52
 */
public class UserServiceImpl implements UserService{

    public UserModel getUserInfo(int userid) {
        return UserModel.builder()
                .userid(userid)
                .username("某某人")
                .nickname("某某昵称")
                .email("111111@qq.com")
                .build();
    }
}
