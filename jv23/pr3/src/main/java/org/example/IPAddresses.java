package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IPAddresses {
    private static final int MAX_PART_VALUE = 255;
    private static final int PARTS_NUMBER = 4;
    private static final int THIRD_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int FIRST_INDEX = 2;
    private static final int HOST_INDEX = 3;

    public static long countIPBetween(String start, String end) {
        if (start.equals(end)) {
            return 0;
        }

        List<Integer> startValues = Arrays.stream(start.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> endValues = Arrays.stream(end.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        if(startValues.size() != 4 || endValues.size() != 4){
            throw new RuntimeException("incorrect IP address");
        }

        int addressesNumber = 0;
        for (int i = 0; i < 4; i++) {
            addressesNumber += (startValues.get(i) - endValues.get(i)) * (256 * (3 - i));
        }
        return Math.abs(addressesNumber);
    }
}