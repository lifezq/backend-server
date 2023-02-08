package com.dpi.common.utils;

import java.util.Random;

/**
 * @Package com.dpi.common.utils
 * @ClassName RealmUtil
 * @Description TODO
 * @Author Ryan
 * @Date 2023/2/8
 */
public class RealmUtil {

    /**
     * generate realm name
     *
     * @return String
     */
    public static String generateRealm() {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return "R" + generatedString;
    }
}
