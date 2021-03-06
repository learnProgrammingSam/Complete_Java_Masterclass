package com.rajatsachdeva;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// To make the class purely Immutable, we need following change
public class Location {
    // final makes it clear that these fields shouldn't be changed
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        // To avoid NullPointerException we need a null check
        if (null == exits) {
            this.exits = new LinkedHashMap<>();
        } else {
            this.exits = new LinkedHashMap<>(exits);
        }
        this.exits.put("Q", 0);
    }

    /*public void addExit(String direction, int location) {
        exits.put(direction, location);
    }*/

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {

        // Following doesn't allows the external entities to change original copy
        // So only copy of Map is provided to the caller, which is good
        // return a new HashMap, and copied exits Map in it , Copy Constructor ?
        return new LinkedHashMap<String, Integer>(exits);
    }

    protected void addExit(String direction, int destination) {
        exits.put(direction,destination);
    }
}
