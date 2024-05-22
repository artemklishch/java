package org.example;

public class IPAddresses {
    public static long ipToLong(String ipAddress) {
        String[] octets = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result += Long.parseLong(octets[i]) << ((3 - i) * 8);
        }
        return result;
    }

    public static long countIPBetween(String start, String end) {
        long startVal = ipToLong(start);
        long endVal = ipToLong(end);

        // Calculate the number of addresses
        return (long) (endVal - startVal);
    }
}