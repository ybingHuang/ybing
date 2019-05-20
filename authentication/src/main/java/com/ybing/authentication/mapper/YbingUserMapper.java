package com.ybing.authentication.mapper;

import com.ybing.authentication.common.YbingBaseMapper;
import com.ybing.authentication.entity.YbingUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by niko on 2019/5/20.
 */
@Mapper
public interface YbingUserMapper extends YbingBaseMapper<YbingUser> {
}
