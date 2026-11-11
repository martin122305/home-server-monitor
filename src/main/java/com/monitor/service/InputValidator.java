package com.monitor.service;

import com.monitor.exception.InvalidDeviceConfigException;

public class InputValidator {

    public static void validateIpAddress(String ip) throws InvalidDeviceConfigException {
        if (ip == null || ip.isBlank()) {
            throw new InvalidDeviceConfigException("IP cím nem lehet üres!");
        }
        
        // Egyszerű IPv4 / Hostname formátum ellenőrzés
        String ipRegex = "^(([0-9]{1,3}\\.){3}[0-9]{1,3}|localhost|[a-zA-Z0-9.-]+)$";
        if (!ip.matches(ipRegex)) {
            throw new InvalidDeviceConfigException("Érvénytelen IP cím vagy host formátum: " + ip);
        }
    }

    public static void validatePort(int port) throws InvalidDeviceConfigException {
        if (port < 1 || port > 65535) {
            throw new InvalidDeviceConfigException("A port számnak 1 és 65535 között kell lennie! (Megadott: " + port + ")");
        }
    }
}