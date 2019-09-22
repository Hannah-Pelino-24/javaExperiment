package javaexperiment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class schedule {

    private String course;
    private String year;
    private String subject;
    private String schedule;
    private String unit;

    Scanner scanner = new Scanner(System.in);

    public schedule() {
    }

    public schedule(String course, String year, String subject, String schedule, String unit) {
        this.course = course;
        this.year = year;
        this.subject = subject;
        this.schedule = schedule;
        this.unit = unit;
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

    public boolean check(String name) {
        String rule = "^[a-zA-Z ]*$";
        return name.matches(rule);
    }

    public boolean checkInt(String age) {
        String rule = "\\d+";
        return age.matches(rule);
    }

    public int schedule(int id, int accId) throws Exception {
        BufferedWriter scheduleWriter = new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\schedule.txt", true));

        System.out.println("***STEP 3***");
        do {
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

        scheduleWriter.write(id + "\t" + accId + "\t" + course + "\t" + year + "\t" + subject + "\t" + schedule + "\t" + unit);
        scheduleWriter.newLine();
        scheduleWriter.close();
        return 0;
    }
}
