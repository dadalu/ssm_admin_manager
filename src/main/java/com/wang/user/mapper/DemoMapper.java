package com.wang.user.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface DemoMapper {
    /**
     * 查询所有用户信息
     * @return
     */
    List<Map> getUser(Map map);
}
