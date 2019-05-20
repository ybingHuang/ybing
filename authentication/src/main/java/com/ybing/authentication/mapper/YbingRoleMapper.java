package com.ybing.authentication.mapper;

import com.ybing.authentication.common.YbingBaseMapper;
import com.ybing.authentication.entity.YbingRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by niko on 2019/5/20.
 */
public interface YbingRoleMapper extends YbingBaseMapper<YbingRole> {

    @Select("select * from role r inner join user_role ur on r.id = ur.role_id where ur.user_id=#{userId}")
    List<YbingRole> selectRoleByUserId(Long userId);
}
