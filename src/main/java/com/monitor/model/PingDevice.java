package com.monitor.model;

public class PingDevice extends MonitoredDevice {

    public PingDevice(String id, String name, String ipAddress) {
        super(id, name, ipAddress);
    }

    @Override
    public boolean checkHealth() {
        long latency = (long) (Math.random() * 80) + 5;
        setResponseTimeMs(latency);
        
        if (latency > 70) {
            setStatus(Status.WARNING);
        } else {
            setStatus(Status.ONLINE);
        }
        return getStatus() != Status.OFFLINE;
    }
}