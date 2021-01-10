

import java.util.Date;
import java.util.List;

public class Meeting {
    private String meetingRoom;
    private String Name;
    private String description;
    private List<String> attendees;
    private Date from;
    private Date to;
    private int day;
    private String timePeriod;

    public Meeting(String meetingRoom, String name, String description, List<String> attendees, Date from, Date to, int day, String timePeriod) {
        this.meetingRoom = meetingRoom;
        Name = name;
        this.description = description;
        this.attendees = attendees;
        this.from = from;
        this.to = to;
        this.day = day;
        this.timePeriod = timePeriod;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

}
