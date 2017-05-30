package com.bahinskyi.advertisement.service;

import com.bahinskyi.advertisement.api.dto.AdvertisementVO;
import com.bahinskyi.advertisement.domain.advertisement.Advertisement;
import com.bahinskyi.advertisement.exception.AdvertisementBoardException;
import com.bahinskyi.advertisement.repository.AdvertisementRepository;
import com.bahinskyi.advertisement.util.UserKeeper;
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
    private final ModelMapper modelMapper;
    private final UserKeeper userKeeper;

    @Autowired
    public AdvertisementService(AdvertisementRepository advertisementRepository, ModelMapper modelMapper, UserKeeper userKeeper) {
        this.advertisementRepository = advertisementRepository;
        this.modelMapper = modelMapper;
        this.userKeeper = userKeeper;
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
        Set<AdvertisementVO> advertisements = new TreeSet<>(Comparator.comparing(AdvertisementVO::getCreationDate));
        advertisementRepository.findByDeletedFalseAndUserId(userKeeper.loggedUser().getId())
                .forEach(ad -> advertisements.add(modelMapper.map(ad, AdvertisementVO.class)));
        return advertisements;
    }

    @Override
    public Long postAdvertisement(AdvertisementVO advertisementVO) {
        Advertisement advertisement = modelMapper.map(advertisementVO, Advertisement.class);
        advertisement.setUser(userKeeper.loggedUser());
        return advertisementRepository.save(advertisement).getId();
    }
}
