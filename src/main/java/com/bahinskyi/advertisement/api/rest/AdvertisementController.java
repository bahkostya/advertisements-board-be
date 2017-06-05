package com.bahinskyi.advertisement.api.rest;

import com.bahinskyi.advertisement.api.dto.AdvertisementVO;
import com.bahinskyi.advertisement.exception.AdvertisementBoardException;
import com.bahinskyi.advertisement.service.AdvertisementManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by quento on 29.05.17.
 */

@Controller
public class AdvertisementController {

    private final AdvertisementManager advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementManager advertisementService) {
        this.advertisementService = advertisementService;
    }

    @CrossOrigin()
    @GetMapping("advertisement/{advertisementId}")
    public @ResponseBody AdvertisementVO getAdvertisement(@PathVariable Long advertisementId) {
        return advertisementService.getAdvertisement(advertisementId);
    }

    @CrossOrigin()
    @GetMapping("advertisements")
    public @ResponseBody Set<AdvertisementVO> getAdvertisements() {
        return advertisementService.getAdvertisements();
    }

    @CrossOrigin()
    @GetMapping("secured")
    public @ResponseBody Set<AdvertisementVO> getMyAdvertisements() {
        return advertisementService.getMyAdvertisements();
    }

    @PutMapping("secured")
    public @ResponseBody AdvertisementVO postAdvertisement(@RequestBody AdvertisementVO advertisementVO) {
        Long entityId = advertisementService.postAdvertisement(advertisementVO);
        return getAdvertisement(entityId);
    }
}
