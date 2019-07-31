package com.mtl.server;

import com.mtl.model.UserModel;

/**
 * @author mtl
 * @Description: User服务接口
 * @date 2019/7/31 18:42
 */
public interface UserService {
    /**
     * 获取用户信息
     * @param userid 用户id
     * @return
     */
    UserModel getUserInfo(int userid);
}
