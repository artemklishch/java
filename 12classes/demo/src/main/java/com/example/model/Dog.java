package com.example.model;

import com.example.*;;

public class Dog extends Animal {
    public long tailLength;

    private String owner;

    public boolean hasOwner() {
        if (owner == null) {
            return false;
        }
        return true;
    }

    public void setOwner(String ownerName) { // this is setter
        owner = ownerName;
    }
}
