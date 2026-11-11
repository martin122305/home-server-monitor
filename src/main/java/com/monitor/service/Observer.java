package com.monitor.service;

import com.monitor.model.MonitoredDevice;

public interface Observer {
    void onStatusChanged(MonitoredDevice device);
}