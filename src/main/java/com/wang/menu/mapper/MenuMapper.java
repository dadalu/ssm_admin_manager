package com.wang.menu.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface MenuMapper {

    List getMenu(Map map);
     void insertMenu(Map map);

}