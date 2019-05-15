package com.ybing.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by niko on 2019/1/2.
 */
@NoRepositoryBean
public interface YbingBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>{

}
