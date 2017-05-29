package com.bahinskyi.advertisement.repository;

import com.bahinskyi.advertisement.domain.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;
import java.util.Set;

/**
 * Created by quento on 29.05.17.
 */

@NoRepositoryBean
public interface AbstractRepository<T> extends CrudRepository<T, Long> {

    T findByIdAndDeletedFalse(Long id);

    Set<T> findByDeletedFalse();
}
