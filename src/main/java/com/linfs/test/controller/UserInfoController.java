package com.linfs.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linfs.test.bean.UserInfo;
import com.linfs.test.service.UserInfoService;
import com.linfs.test.util.Result;
import com.linfs.test.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author linfs
 * @create 2019-10-28-22:47
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 根据用户 ID 获取学生信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UserInfo findById(@PathVariable Long id) {
        return userInfoService.getById(id);
    }

    /**
     * 查询所有学生信息
     *
     * @return
     */
    @GetMapping("/all")
    public List<UserInfo> findAll() {
        return userInfoService.list(null);
    }

    /**
     * 查询分数 >fraction 的学生信息
     *
     * @param fraction
     * @return
     */
    @GetMapping("/fraction/{fraction}")
    public IPage<UserInfo> getByFraction(@PathVariable Long fraction) {
        IPage<UserInfo> page = new Page<>();
        page.setSize(5);
        page.setCurrent(1);
        page = userInfoService.selectUserInfoByGtFraction(page, fraction);
        return page;
    }


    /**
     * 分页查询学生信息
     *
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/page/{num}/{size}")
    public IPage<UserInfo> getinfoListPage(@PathVariable Integer num, @PathVariable Integer size) {
        IPage<UserInfo> page = new Page<>(num, size);
        page = userInfoService.page(page, null);
        return page;
    }

    /**
     * 根据指定字段查询用户信息集
     *
     * @param map
     * @return
     */
    @PostMapping("/selectbycolumn")
    public Result getListMap(@RequestBody Map<String, Object> map) {
        Collection<UserInfo> userInfos = userInfoService.listByMap(map);
        return new Result(true, StatusCode.OK, "查询成功", userInfos);
    }

    /**
     * 插入学生信息
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return new Result(true, StatusCode.OK, "插入成功");
    }

    /**
     * 按要求删除
     *
     * @param map
     * @return
     */
    @PostMapping("/deleteByMap")
    public Result deleteByMap(@RequestBody Map<String, Object> map) {
        userInfoService.removeByMap(map);
        return new Result(true, StatusCode.OK, "删除成功");
    }




}
