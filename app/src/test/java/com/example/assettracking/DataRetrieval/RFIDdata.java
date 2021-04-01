package com.example.assettracking.DataRetrieval;

import com.example.assettracking.Database.ToolsandEquipment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RFIDdata {
    @Test
    public void getHistory(){
        ToolsandEquipment toolsandEquipment = new ToolsandEquipment();
        boolean result= toolsandEquipment.checkinData();
        assertEquals(true,result);
    }
}
