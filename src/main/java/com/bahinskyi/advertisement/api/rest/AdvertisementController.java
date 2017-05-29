package com.bahinskyi.advertisement.api.rest;

import com.bahinskyi.advertisement.api.dto.AdvertisementVO;
import com.bahinskyi.advertisement.exception.AdvertisementBoardException;
import com.bahinskyi.advertisement.service.AdvertisementManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.Set;

/**
 * Created by quento on 29.05.17.
 */

@Controller("advertisements")
public class AdvertisementController {

    private final AdvertisementManager advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementManager advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("get/{advertisementId}")
    public AdvertisementVO getAdvertisement(@PathVariable Long advertisementId) {
        return advertisementService.getAdvertisement(advertisementId);
    }

    @GetMapping("get")
    public Set<AdvertisementVO> getAdvertisements() {
        return advertisementService.getAdvertisements();
    }

    @GetMapping("secured/my")
    public Set<AdvertisementVO> getMyAdvertisements() {
        return null;
    }

    @PutMapping("secured/ad")
    public ResponseEntity<String> postAdvertisement(@RequestBody AdvertisementVO advertisementVO) {
        return null;
    }
}
