package javaexperiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class schedule {

    private String course;
    private String year;
    private String subject;
    private String schedule;
    private String unit;
    private int schedID =1;

    Scanner scanner = new Scanner(System.in);

    public schedule() {
           try {
            this.schedID = setSchedId();
        } catch (IOException ex) {
//            System.out.println();
        }
    }

    public schedule(String course, String year, String subject, String schedule, String unit, int schedID) {
        this.course = course;
        this.year = year;
        this.subject = subject;
        this.schedule = schedule;
        this.unit = unit;
        this.schedID = schedID;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getSchedID() {
        return schedID;
    }

    public void setSchedID(int schedID) {
        this.schedID = schedID;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    
    public boolean check(String name) {
        String rule = "^[a-zA-Z ]*$";
        return name.matches(rule);
    }

    public boolean checkInt(String age) {
        String rule = "\\d+";
        return age.matches(rule);
    }

    public int schedule(int accId) throws Exception {
        BufferedWriter scheduleWriter = new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\schedule.txt", true));

        Scanner scan = new Scanner(System.in);
        System.out.println("Want to add schedule???\nPress 1 for Yes\nPress 2 for No");
        int addSched = scan.nextInt();
        if (addSched == 1) {
            do {
                System.out.println("***STEP 3***");
                
                System.out.print("Enter Course: ");
                String Course = scanner.nextLine();
                if (check(Course)) {
                    this.course = Course;
                } else {
                    try {
                        throw new MyException("Invalid input...");
                    } catch (MyException ex) {
//                    System.out.println("");
                    }
                }
            } while (course == null);

            do {
                System.out.print("Year : ");
                String temp = scanner.nextLine();
                try {
                    if (checkInt(temp)) {
                        this.year = temp;
                    } else {
                        throw new MyException("Invalid input!");
                    }

                } catch (MyException e) {
                }

            } while (year == null);

            do {
                System.out.print("Enter Subject: ");
                String Subject = scanner.nextLine();
                if (check(Subject)) {
                    this.subject = Subject;
                } else {
                    try {
                        throw new MyException("Invalid input...");
                    } catch (MyException ex) {
//                    System.out.println("");
                    }
                }
            } while (subject == null);

            do {
                System.out.print("Enter Schedule: ");
                String Schedule = scanner.nextLine();
                if (check(Schedule)) {
                    this.schedule = Schedule;
                } else {
                    try {
                        throw new MyException("Invalid input...");
                    } catch (MyException ex) {
//                    System.out.println("");
                    }
                }
            } while (schedule == null);

            do {
                System.out.print("Unit : ");
                String temp = scanner.nextLine();
                try {
                    if (checkInt(temp)) {
                        this.unit = temp;
                    } else {
                        throw new MyException("Invalid input!");
                    }

                } catch (MyException e) {
                }

            } while (unit == null);

            scheduleWriter.write(schedID + "\t" + accId + "\t" + course + "\t" + year + "\t" + subject + "\t" + schedule + "\t" + unit);
            scheduleWriter.newLine();
            scheduleWriter.close();
            return 0;
        }
        return 0;
    }
    
    public int setSchedId() throws FileNotFoundException, IOException {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\schedule.txt"));
        String line = reader.readLine();
        while (line != null) {
            ++schedID;
            line = reader.readLine();
        }
        reader.close();
        return schedID;
    }

}
