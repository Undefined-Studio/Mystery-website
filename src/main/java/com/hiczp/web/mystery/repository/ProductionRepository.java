package com.hiczp.web.mystery.repository;

import com.hiczp.web.mystery.entity.Production;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by czp on 17-7-3.
 */
public interface ProductionRepository extends PagingAndSortingRepository<Production, Long> {
    List<Production> findTop8ByOrderBySortDesc();
}
