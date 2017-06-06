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
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by quento on 29.05.17.
 */

@Service
public class AdvertisementService implements AdvertisementManager {

    private final AdvertisementRepository advertisementRepository;
    private final ModelMapper modelMapper;
    private final UserKeeper userKeeper;

    private Supplier<TreeSet<AdvertisementVO>> creationDateSupplier =
            () -> new TreeSet<>(Comparator.comparing(AdvertisementVO::getCreationDate));

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
        return advertisementRepository.findByDeletedFalse()
                .stream()
                .map(ad -> modelMapper.map(ad, AdvertisementVO.class))
                .collect(Collectors.toCollection(creationDateSupplier));
    }

    @Override
    public Set<AdvertisementVO> getMyAdvertisements() {
        return advertisementRepository.findByDeletedFalseAndUserId(userKeeper.loggedUser().getId())
                .stream()
                .map(ad -> modelMapper.map(ad, AdvertisementVO.class))
                .collect(Collectors.toCollection(creationDateSupplier));
    }

    @Override
    public Long postAdvertisement(AdvertisementVO advertisementVO) {
        Advertisement advertisement = modelMapper.map(advertisementVO, Advertisement.class);
        advertisement.setUser(userKeeper.loggedUser());
        return advertisementRepository.save(advertisement).getId();
    }

    @Override
    public void deleteAdvertisement(Long advertisementId) {
        Optional<Advertisement> advertisement = Optional.ofNullable(advertisementRepository.findByIdAndDeletedFalse(advertisementId));
        advertisementRepository.markDeleted(advertisement.orElseThrow(() -> new AdvertisementBoardException("Requested advertisement does not exist")));
    }

    @Override
    public void updateAdvertisement(AdvertisementVO advertisementVO) {
        Advertisement advertisement = modelMapper.map(advertisementVO, Advertisement.class);
        advertisement.setUser(userKeeper.loggedUser());
        advertisementRepository.save(advertisement);
    }
}
