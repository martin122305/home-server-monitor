package com.monitor.exception;

public class InvalidDeviceConfigException extends Exception {
    public InvalidDeviceConfigException(String message) {
        super(message);
    }

    public InvalidDeviceConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}