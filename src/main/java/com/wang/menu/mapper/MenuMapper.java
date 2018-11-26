package com.wang.menu.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface MenuMapper {
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取菜单
     * @Param [map]
     * @return java.util.List
     **/
    List getMenu(Map map);
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 添加菜单
     * @Param [map]
     * @return void
     **/
     void insertMenu(Map map);

}