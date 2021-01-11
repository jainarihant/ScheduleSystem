

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
        List<String> meetingsWithcollisonTime = new ArrayList<>();
        Map<String, Meeting> meetings = user.getMeetings();
        if(!meetings.containsKey(meetingName)){
            for(String mNames: meetings.keySet()){
                Meeting meeting1 = meetings.get(mNames);
                if(isDateWithiRange(meeting1.getTo(), meeting1.getFrom(), meeting.getTo() ) || meeting1.getTo().equals(meeting.getTo())){
                    meetingsWithcollisonTime.add(meeting1.getName());
                }
                if (isDateWithiRange(meeting1.getTo(),meeting1.getFrom(), meeting.getFrom()) || meeting1.getFrom().equals(meeting.getFrom())){
                    meetingsWithcollisonTime.add(meeting1.getName());
                }
            }

            if(meetingsWithcollisonTime.isEmpty()){
                meetings.put(meeting.getName(), meeting);
            } else {
                System.out.println("Meeting time collides with meeting Name: "+ meetingsWithcollisonTime.get(0));
                return false;
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
