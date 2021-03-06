package tast51;

import java.util.HashMap;
import java.util.Map;

public final class Location {
    private final int locationID;
    private final String description;
    private final Map exits;

    public Location(int locationID, String description, Map exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits == null) {
            this.exits = new HashMap();
        } else {
            this.exits = new HashMap(exits);
        }
        this.exits.put("Q", 0);

    }
    public int getLocationID() {
        return locationID;
    }
    public String getDescription() {
        return description;
    }
    public Map getExits() {
        return new HashMap<>(exits);
    }

}
