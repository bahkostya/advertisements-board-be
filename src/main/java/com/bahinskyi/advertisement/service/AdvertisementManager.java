package com.bahinskyi.advertisement.service;

import com.bahinskyi.advertisement.api.dto.AdvertisementVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

/**
 * Created by quento on 29.05.17.
 */
public interface AdvertisementManager {

    @Transactional(readOnly = true)
    AdvertisementVO getAdvertisement(Long id);

    @Transactional(readOnly = true)
    Set<AdvertisementVO> getAdvertisements();

    @Transactional(readOnly = true)
    Set<AdvertisementVO> getMyAdvertisements();

    @Transactional
    Long postAdvertisement(AdvertisementVO advertisementVO);

    @Transactional
    void deleteAdvertisement(Long advertisementId);

    @Transactional
    void updateAdvertisement(AdvertisementVO advertisementVO);
}
