package com.project.hometask;

public class Task7 {
    public static String uint32ToIp(long ip) {
        StringBuilder sb = new StringBuilder();
        sb.append(ip >>> 24).append(".")
                .append((ip >> 16) & 0xFF).append(".")
                .append((ip >> 8) & 0xFF).append(".")
                .append(ip & 0xFF);
        return sb.toString();
    }
}
