package com.monitor.service;

import com.monitor.model.MonitoredDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonitoringService {
    private final List<MonitoredDevice> devices = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public void addDevice(MonitoredDevice device) {
        devices.add(device);
    }

    public List<MonitoredDevice> getDevices() {
        return new ArrayList<>(devices);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void runMonitoringCycle() {
        for (MonitoredDevice device : devices) {
            device.checkHealth();
            notifyObservers(device);
        }
    }

    private void notifyObservers(MonitoredDevice device) {
        for (Observer observer : observers) {
            observer.onStatusChanged(device);
        }
    }

    public void sortByResponseTime() {
        Collections.sort(devices);
    }
}