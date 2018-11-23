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

    public List getMenu(Map map) {
        return mapper.getMenu(map);
    }

    public void insertMenu(Map map) {
        mapper.insertMenu(map);
    }
}
