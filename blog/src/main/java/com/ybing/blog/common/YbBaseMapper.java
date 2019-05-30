package com.ybing.blog.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by niko on 2019/5/30.
 */
public interface YbBaseMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
