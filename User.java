

import java.util.Map;

public class User {
    private String name;
    private Map<String, Meeting> meetings;

    public User(String name, Map<String, Meeting> meetings) {
        this.name = name;
        this.meetings = meetings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Map<String, Meeting> meetings) {
        this.meetings = meetings;
    }

}
