

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class Scheduler {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Meeting> meetingMap = new HashMap<>();
    static InputStreamReader r=new InputStreamReader(System.in);
    static BufferedReader br=new BufferedReader(r);
    static User user = new User("Arihant", meetingMap);

    public static void main(String[] args)throws Exception{
        System.out.println("Schedule Management Service");
        System.out.println("Enter 1 to add meetings");
        System.out.println("Enter 2 to list of names of meetings scheduled");
        System.out.println("Enter 3 to exit menu");
        int menuInput = sc.nextInt();
        while (menuInput != 3){
            switch (menuInput){
                case(1):
                    addMeetings();
                    break;
                case (2):
                    showListOfMeetings();
                    break;
                default:
                    System.out.println("Enter right choice");
            }
        }
        br.close();
        r.close();
    }

    public static void showListOfMeetings() throws Exception{
        ManagementService managementService = new ManagementService();
        List<String> list = managementService.getListOfMeetings(user);
        if(list.isEmpty()){
            System.out.println("No meetings added!");
        }
        for(String names: list){
            System.out.println(names);
        }
        main(null);
    }

    public static void addMeetings() throws Exception{
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        ManagementService managementService = new ManagementService();
        System.out.println("Enter meeting room name: ");
        String meetingRoom = br.readLine();
        System.out.println("Enter meeting name: ");
        String name =  br.readLine();
        System.out.println("Enter meeting description: ");
        String description = br.readLine();
        List<String> attendees = new ArrayList<>();
        System.out.println("Enter start time of meeting in dd-MM-yyyy HH:mm:ss format: ");
        Date from = formatter.parse(br.readLine());
        System.out.println("Enter end time of meeting dd-MM-yyyy HH:mm:ss format: ");
        Date to =  formatter.parse(br.readLine());
        Calendar c = Calendar.getInstance();
        c.setTime(from);
        int day = (c.get(Calendar.DAY_OF_WEEK));
        long duration = from.getTime() - to.getTime();

        if(managementService.addMeeting(user, new Meeting(meetingRoom, name, description, attendees, from, to, day, String.valueOf(duration)))){
            System.out.println("Meeting added successfully");
        }
        main(null);
    }
}
