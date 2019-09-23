package javaexperiment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class personal_Info {

    private String fname;
    private String lname;
    private String age;

    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);

    public personal_Info() {
    }

    public personal_Info(String fname, String lname, String age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean check(String name) {
        String rule = "^[a-zA-Z ]*$";
        return name.matches(rule);
    }

    public boolean checkInt(String age) {
        String rule = "\\d+";
        return age.matches(rule);
    }

    public void personal_Info(int id, int accId) throws IOException {
        BufferedWriter personalWriter = new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\personal_Info.txt", true));

        System.out.println("***STEP 2***");
        do {
            System.out.print("Enter First Name: ");
            String fname = scanner.nextLine();
            if (check(fname)) {
                this.fname = fname;
            } else {
                try {
                    throw new MyException("Invalid Name...");
                } catch (MyException ex) {
//                    System.out.println("");
                }
            }
        } while (fname == null);

        do {
            System.out.print("Enter Last Name: ");
            String lname = scanner.nextLine();
            if (check(lname)) {
                this.lname = lname;
            } else {
                try {
                    throw new MyException("Invalid Name...");
                } catch (MyException ex) {
//                    System.out.println("");
                }
            }
        } while (lname == null);
        
        do {
            System.out.print("Age : ");
            String temp = scanner1.next();
            try {
                if (checkInt(temp)) {
                    this.age = temp;
                } else {
                    throw new MyException("invalid input!");
                }

            } catch (MyException e) {
            }

        } while (age == null);

        personalWriter.write(id + "\t"+ accId +"\t" + fname + "\t" + lname + "\t"+age);
        personalWriter.newLine();
        personalWriter.close();
    }

}
