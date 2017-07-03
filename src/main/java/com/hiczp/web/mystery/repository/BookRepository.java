package com.hiczp.web.mystery.repository;

import com.hiczp.web.mystery.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by czp on 17-7-3.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findTop8ByOrderBySortDesc();
}
