package com.example.assettracking.DataRetrieval;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GPS {
    @Test
    public void getLatLongi(){
        com.example.assettracking.Database.GPSdata gpSdata = new com.example.assettracking.Database.GPSdata();
        boolean result= gpSdata.mapCoordinates();
        assertEquals(false,result);
    }
}
