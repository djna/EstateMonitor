package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;
    private final String passwordHash;
    private List<Property> properties = new ArrayList<>();

    public User (String initName, String initPasswordHash) {
        name = initName;
        passwordHash = initPasswordHash;
    }

    public String getName() {
        return name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property p) {
        properties.add(p);
    }
}
