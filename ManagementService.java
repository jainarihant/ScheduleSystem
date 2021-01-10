

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ManagementService {

    public List<String> getListOfMeetings(User user){
            List<String> resultList = new ArrayList<>();
            Map<String, Meeting> userMeetings = user.getMeetings();
            for(Meeting meetings: userMeetings.values()){
                resultList.add(meetings.getName());
            }
            return resultList;
    }

    public boolean addMeeting(User user, Meeting meeting){
        String meetingName = meeting.getName();
        String collisionMeetingName = "";
        boolean dateCollides = false;
        Map<String, Meeting> meetings = user.getMeetings();
        if(!meetings.containsKey(meetingName)){
            for(String mNames: meetings.keySet()){
                Meeting meeting1 = meetings.get(mNames);
                dateCollides = isDateWithiRange(meeting1.getTo(), meeting1.getFrom(), meeting.getTo()) &&
                        isDateWithiRange(meeting1.getTo(),meeting1.getFrom(), meeting.getFrom());
                if(dateCollides){
                    collisionMeetingName = meeting1.getName();
                }
            }
            if(!dateCollides){
                meetings.put(meeting.getName(), meeting);
            } else {
                System.out.println("Meeting time collides with meeting Name: "+ collisionMeetingName);
            }
        } else {
            System.out.println("Meeting with the above name already exists, please create a meeting with separate name");
            return false;
        }
        return true;
    }

    private boolean isDateWithiRange(Date to, Date from, Date  inputDate){
        return inputDate.after(from) && inputDate.before(to);
    }

}
