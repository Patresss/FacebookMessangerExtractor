package com.patres.messanger.utils;

import java.nio.charset.StandardCharsets;

public final class StringUtils {

    public static String toUtf(String input) {
        byte[] bytes = input.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
