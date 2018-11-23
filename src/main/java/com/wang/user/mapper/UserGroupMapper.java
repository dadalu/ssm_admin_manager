package com.wang.user.mapper;

import com.wang.user.bo.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Repository
public interface UserGroupMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getUser();
    /**
     * 查询当前用户信息
     * @return
     */
    Map getUserInfo(Map map);
}
