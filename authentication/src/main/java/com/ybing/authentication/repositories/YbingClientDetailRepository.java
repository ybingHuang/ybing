package com.ybing.authentication.repositories;

import com.ybing.authentication.entity.YbingClientDetail;

/**
 * Created by niko on 2019/5/15.
 */
public interface YbingClientDetailRepository extends YbingBaseRepository<YbingClientDetail, Long> {
    YbingClientDetail findYbingClientDetailByCode(String code);
}
