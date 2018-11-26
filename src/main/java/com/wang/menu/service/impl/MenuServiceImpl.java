package com.wang.menu.service.impl;

import com.wang.menu.mapper.MenuMapper;
import com.wang.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("MenuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper mapper;
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 获取菜单
     * @Param [map]
     * @return java.util.List
     **/
    public List getMenu(Map map) {
        return mapper.getMenu(map);
    }
    /*
    *
     * @Author XiaochengWang
     * @Description //TODO 添加菜单
     * @Param
     * @return
     **/
    public void insertMenu(Map map) {
        mapper.insertMenu(map);
    }
}
