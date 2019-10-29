package com.linfs.test.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linfs.test.bean.UserInfo;
import com.linfs.test.dao.UserInfoDao;
import com.linfs.test.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author linfs
 * @create 2019-10-28-22:45
 */
@Service
@Transactional
public class UserInfoIServicempl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

    @Override
    public IPage<UserInfo> selectUserInfoByGtFraction(IPage<UserInfo> page, Long fraction) {
        return this.baseMapper.selectUserInfoByGtFraction(page, fraction);
    }
}
