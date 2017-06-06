package com.bahinskyi.advertisement.util;

import com.bahinskyi.advertisement.exception.AdvertisementBoardException;

import java.util.function.Supplier;

/**
 * Created by quento on 06.06.17.
 */
public final class Guard {

    private Guard() {
    }

    private static void assertTrue(boolean value, Supplier<String> message) {
        if (!value) {
            throw new AdvertisementBoardException(message.get());
        }
    }

    public static void assertFalse(boolean value, Supplier<String> message) {
        assertTrue(!value, message);
    }

    public static void assertNotNull(Object value, String name) {
        assertFalse(value == null, () -> String.format("[%s] should be not null.", name));
    }

    public static void assertNotNull(Object value, Supplier<String> message) {
        assertFalse(value == null, message);
    }


}
