package com.example.assettracking.Database;

public class ToolsandEquipment {
    public String name, rfid;

    public ToolsandEquipment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public boolean checkinData() {
        return false;
    }
}
