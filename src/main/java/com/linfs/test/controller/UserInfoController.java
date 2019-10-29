package com.linfs.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linfs.test.bean.UserInfo;
import com.linfs.test.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linfs
 * @create 2019-10-28-22:47
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/{id}")
    public UserInfo findById(@PathVariable Long id) {
        return userInfoService.getById(id);
    }

    @GetMapping("/all")
    public List<UserInfo> findAll() {
        return userInfoService.list(null);
    }

    @GetMapping("/fraction/{fraction}")
    public IPage<UserInfo> getByFraction(@PathVariable Long fraction) {
        IPage<UserInfo> page = new Page<>();
        page.setSize(5);
        page.setCurrent(1);
        page = userInfoService.selectUserInfoByGtFraction(page, fraction);
        return page;
    }

}
