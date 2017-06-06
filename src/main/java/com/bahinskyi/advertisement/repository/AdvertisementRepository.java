package com.bahinskyi.advertisement.repository;

import com.bahinskyi.advertisement.domain.advertisement.Advertisement;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by quento on 29.05.17.
 */

public interface AdvertisementRepository extends AbstractRepository<Advertisement> {

    List<Advertisement> findByDeletedFalseAndUserId(Long userId);

    @Modifying
    @Query("update Advertisement adv set adv.deleted = true where adv =?1")
    void markDeleted(Advertisement advertisement);
}
