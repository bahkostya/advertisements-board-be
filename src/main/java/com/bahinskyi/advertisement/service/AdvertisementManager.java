package com.bahinskyi.advertisement.service;

import com.bahinskyi.advertisement.api.dto.AdvertisementVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

/**
 * Created by quento on 29.05.17.
 */
public interface AdvertisementManager {

    AdvertisementVO getAdvertisement(Long id);

    Set<AdvertisementVO> getAdvertisements();

    Set<AdvertisementVO> getMyAdvertisements();

    boolean postAdvertisement(AdvertisementVO advertisementVO);
}
