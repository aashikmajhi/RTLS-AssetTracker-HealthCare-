package com.example.assettracking.Asset;

import com.google.android.gms.tasks.Task;

public class Assets {
   // public String id, name, location;
    private Task<Void> key;
    private String value;

    public Assets(Task<Void> key, String value) {
        this.key = key;
        this.value = value;
    }

    public Task<Void> getKey() {
        return key;
    }

    public void setKey(Task<Void> key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
