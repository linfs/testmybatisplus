package com.linfs.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linfs.test.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author linfs
 * @create 2019-10-28-22:42
 */
public interface UserInfoDao extends BaseMapper<UserInfo> {

    /**
     * @param page     分页参数
     * @param fraction 分数
     * @return 分页数据
     */
    IPage<UserInfo> selectUserInfoByGtFraction(IPage<UserInfo> page, @Param("fraction") Long fraction);

}
