package com.dhzm.service.impl;


import com.dhzm.entity.MainUrl;
import com.dhzm.mapper.MenuTreeMapper;
import com.dhzm.service.MenuTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Remy~
 * @date 来自:2022年01月06日 16:14
 */
@Service
public class MenuTreeServiceImpl implements MenuTreeService {
    @Autowired
    private MenuTreeMapper menuTreeMapper;
    @Override
    public MainUrl findTree() {


        return null;
    }
}
