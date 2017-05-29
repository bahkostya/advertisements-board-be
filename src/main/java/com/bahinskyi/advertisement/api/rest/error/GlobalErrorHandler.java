package com.bahinskyi.advertisement.api.rest.error;

import com.bahinskyi.advertisement.exception.AdvertisementBoardException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by quento on 29.05.17.
 */

@ControllerAdvice
public class GlobalErrorHandler {


    private static final Logger LOG = LoggerFactory.getLogger(GlobalErrorHandler.class.getName());

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = AdvertisementBoardException.class)
    public void handleError(AdvertisementBoardException e) {
        LOG.error(e.getMessage());
    }
}
