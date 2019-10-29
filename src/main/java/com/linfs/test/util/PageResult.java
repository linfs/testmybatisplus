package com.linfs.test.util;

import lombok.Data;

import java.util.List;

/**
 * 分页返回结果类
 *
 * @author linfs
 * @create 2019-10-29-12:55
 */
@Data
public class PageResult<T> {

    private Long total;

    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
