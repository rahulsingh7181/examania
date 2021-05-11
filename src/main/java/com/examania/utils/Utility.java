package com.examania.utils;

import javax.servlet.http.HttpServletRequest;

public class Utility {

    public static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr().trim();
            }
        }

        return remoteAddr;
    }
}
