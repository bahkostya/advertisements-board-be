package com.bahinskyi.advertisement.api.rest;

import com.bahinskyi.advertisement.api.dto.AdvertisementVO;
import com.bahinskyi.advertisement.service.AdvertisementManager;
import com.bahinskyi.advertisement.util.Guard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/**
 * Created by quento on 29.05.17.
 */

@Controller
@CrossOrigin
public class AdvertisementController {

    private final AdvertisementManager advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementManager advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("advertisement/{advertisementId}")
    public
    @ResponseBody
    AdvertisementVO getAdvertisement(@PathVariable Long advertisementId) {
        Guard.assertNotNull(advertisementId, "Advertisement.id");
        return advertisementService.getAdvertisement(advertisementId);
    }

    @GetMapping("advertisements")
    public
    @ResponseBody
    Set<AdvertisementVO> getAdvertisements() {
        return advertisementService.getAdvertisements();
    }

    @GetMapping("secured")
    public
    @ResponseBody
    Set<AdvertisementVO> getMyAdvertisements() {
        return advertisementService.getMyAdvertisements();
    }

    @PostMapping("secured")
    public
    @ResponseBody
    Set<AdvertisementVO> postAdvertisement(@RequestBody @Valid AdvertisementVO advertisementVO) {
        advertisementService.postAdvertisement(advertisementVO);
        return getMyAdvertisements();
    }

    @DeleteMapping("secured/{advertisementId}")
    public
    @ResponseBody
    Set<AdvertisementVO> deleteAdvertisement(@PathVariable Long advertisementId) {
        Guard.assertNotNull(advertisementId, "Advertisement.id");
        advertisementService.deleteAdvertisement(advertisementId);
        return getMyAdvertisements();
    }

    @PutMapping("secured")
    public
    @ResponseBody
    Set<AdvertisementVO> updateAdvertisement(@RequestBody @Valid AdvertisementVO advertisementVO) {
        advertisementService.updateAdvertisement(advertisementVO);
        return getMyAdvertisements();
    }
}
