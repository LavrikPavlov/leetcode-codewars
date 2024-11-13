package ru.kazan.level5.Int32toiPV4;

public class Int32ToIpv4 {
    public static void main(String[] args) {
        System.out.println(longToIP(2149583361L));
    }

    public static String longToIP(long ip) {
        return String.format(
                "%d.%d.%d.%d",
                (ip >> 24) & 0xFF,
                (ip >> 16) & 0xFF,
                (ip >> 8) & 0xFF,
                ip & 0xFF
        );
    }
}
