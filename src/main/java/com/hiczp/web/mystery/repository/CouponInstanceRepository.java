package com.hiczp.web.mystery.repository;

import com.hiczp.web.mystery.entity.CouponInstance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by czp on 17-7-11.
 */
public interface CouponInstanceRepository extends CrudRepository<CouponInstance, Long> {
    List<CouponInstance> findByAccount_Username(String username);
}
