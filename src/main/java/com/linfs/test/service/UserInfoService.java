package com.linfs.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linfs.test.bean.UserInfo;

/**
 * @author linfs
 * @create 2019-10-28-22:43
 */
public interface UserInfoService extends IService<UserInfo> {

    IPage<UserInfo> selectUserInfoByGtFraction(IPage<UserInfo> page, Long fraction);

}
