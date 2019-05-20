package com.ybing.authentication.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by niko on 2019/5/20.
 */
public interface YbingBaseMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
