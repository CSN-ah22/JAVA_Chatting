package com.daelim.five.Data;

import java.io.Serializable;

public class SettingData implements Serializable {
    private String server, port;

    public SettingData() {}
    public SettingData(String ser, String po) {
        server = ser;
        port = po;
    }

    public void setServer(String server) { this.server = server; }
    public String getServer() {
        return server;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getPort() {
        return port;
    }
}
