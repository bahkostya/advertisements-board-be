package com.bahinskyi.advertisement.exception;

/**
 * Created by quento on 29.05.17.
 */

public class AdvertisementBoardException extends RuntimeException {

    public AdvertisementBoardException() {
        super();
    }

    public AdvertisementBoardException(String message) {
        super(message);
    }

    public AdvertisementBoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdvertisementBoardException(Throwable cause) {
        super(cause);
    }
}
