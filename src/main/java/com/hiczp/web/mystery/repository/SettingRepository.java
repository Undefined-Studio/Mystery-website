package com.hiczp.web.mystery.repository;

import com.hiczp.web.mystery.entity.Setting;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by czp on 17-7-13.
 */
public interface SettingRepository extends CrudRepository<Setting, Long> {
    Setting findByProperty(String property);
}
