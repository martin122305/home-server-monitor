package com.monitor.model;

public abstract class MonitoredDevice implements Comparable<MonitoredDevice> {
    private final String id;
    private String name;
    private String ipAddress;
    private Status status;
    private long responseTimeMs;

    public MonitoredDevice(String id, String name, String ipAddress) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Device ID cannot be empty");
        }
        if (ipAddress == null || ipAddress.isBlank()) {
            throw new IllegalArgumentException("IP address cannot be empty");
        }
        this.id = id;
        this.name = name;
        this.ipAddress = ipAddress;
        this.status = Status.UNKNOWN;
        this.responseTimeMs = -1;
    }

    public abstract boolean checkHealth();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Status getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    public long getResponseTimeMs() {
        return responseTimeMs;
    }

    protected void setResponseTimeMs(long responseTimeMs) {
        this.responseTimeMs = responseTimeMs;
    }

    @Override
    public int compareTo(MonitoredDevice other) {
        return Long.compare(this.responseTimeMs, other.responseTimeMs);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s (%d ms)", id, name, ipAddress, status, responseTimeMs);
    }
}