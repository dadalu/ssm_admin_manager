package com.wang.menu.service;

import java.util.List;
import java.util.Map;

public interface MenuService {
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
