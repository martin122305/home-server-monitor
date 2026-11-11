package com.monitor.service;

import com.monitor.model.MonitoredDevice;
import com.monitor.model.Status;

public class ConsoleAlertObserver implements Observer {
    @Override
    public void onStatusChanged(MonitoredDevice device) {
        if (device.getStatus() == Status.OFFLINE) {
            System.out.printf("🚨 [RIASZTÁS] Eszköz elérhetetlen! %s (%s)%n", 
                    device.getName(), device.getIpAddress());
        } else if (device.getStatus() == Status.WARNING) {
            System.out.printf("⚠️ [FIGYELMEZTETÉS] Magas válaszidő: %s (%d ms)%n", 
                    device.getName(), device.getResponseTimeMs());
        }
    }
}