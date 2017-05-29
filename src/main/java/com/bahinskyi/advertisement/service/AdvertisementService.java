package com.bahinskyi.advertisement.service;

import com.bahinskyi.advertisement.api.dto.AdvertisementVO;
import com.bahinskyi.advertisement.domain.advertisement.Advertisement;
import com.bahinskyi.advertisement.exception.AdvertisementBoardException;
import com.bahinskyi.advertisement.repository.AdvertisementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by quento on 29.05.17.
 */

@Service
public class AdvertisementService implements AdvertisementManager {

    private final AdvertisementRepository advertisementRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }


    @Override
    public AdvertisementVO getAdvertisement(Long id) {
        Optional<Advertisement> ad = Optional.ofNullable(advertisementRepository.findByIdAndDeletedFalse(id));
        return modelMapper
                .map(ad.orElseThrow(() -> new AdvertisementBoardException("Incorrect ID requested from UI")), AdvertisementVO.class);
    }

    @Override
    public Set<AdvertisementVO> getAdvertisements() {
        Set<AdvertisementVO> advertisements = new TreeSet<>(Comparator.comparing(AdvertisementVO::getCreationDate));
        advertisementRepository.findByDeletedFalse().forEach(ad -> advertisements.add(modelMapper.map(ad, AdvertisementVO.class)));
        return advertisements;
    }

    @Override
    public Set<AdvertisementVO> getMyAdvertisements() {
        return null;
    }

    @Override
    public boolean postAdvertisement(AdvertisementVO advertisementVO) {
        return false;
    }
}
