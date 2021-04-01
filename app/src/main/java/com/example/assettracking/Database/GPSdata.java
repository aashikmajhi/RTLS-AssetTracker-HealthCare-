package com.example.assettracking.Database;

public class GPSdata {
    public double lati,longi;
    public String toolname;
    public GPSdata() {
    }


    public GPSdata(double lati, double longi, String toolname) {
        this.lati = lati;
        this.longi = longi;
        this.toolname = toolname;
    }

    public GPSdata(double lati, double longi) {
        this.lati = lati;
        this.longi = longi;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public boolean mapCoordinates() {
        return false;
    }
}
