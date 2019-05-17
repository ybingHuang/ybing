package com.ybing.authentication.repositories;

import com.ybing.authentication.entity.YbingRole;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by niko on 2019/5/15.
 */
public interface YbingRoleRepository extends YbingBaseRepository<YbingRole, Long> {

    @Query(value = "select r.* from YbingRole r inner join YbingUserRole t on r.id = t.roleId where t.userId = ?1 ", nativeQuery = true)
    List<YbingRole> findRoles(Long userId);
}
