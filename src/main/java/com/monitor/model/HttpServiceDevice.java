package com.monitor.model;

public class HttpServiceDevice extends MonitoredDevice {
    private final int port;
    private final String endpoint;

    public HttpServiceDevice(String id, String name, String ipAddress, int port, String endpoint) {
        super(id, name, ipAddress);
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port number");
        }
        this.port = port;
        this.endpoint = endpoint != null ? endpoint : "/";
    }

    public int getPort() {
        return port;
    }

    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public boolean checkHealth() {
        long latency = (long) (Math.random() * 150) + 10;
        setResponseTimeMs(latency);

        if (Math.random() < 0.15) {
            setStatus(Status.OFFLINE);
            return false;
        }

        setStatus(Status.ONLINE);
        return true;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (http://%s:%d%s) - %s (%d ms)", 
                getId(), getName(), getIpAddress(), port, endpoint, getStatus(), getResponseTimeMs());
    }
}