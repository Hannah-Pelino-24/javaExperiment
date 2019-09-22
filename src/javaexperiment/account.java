package javaexperiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class account {

    Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;
    private int id= 1;
    private int accId =  18100 + id;

    public account() {
        try {
            this.id = setId();
        } catch (IOException ex) {
//            System.out.println();
        }
    }

    public int getAccId() {
        return accId;
    }

    public account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void userMenu() throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\account.txt", true));
            Scanner scan = new Scanner(System.in);
            
                        System.out.println("***STEP 1***");
            System.out.print("Enter username: ");
            String userName = scan.nextLine();
            
            System.out.print("Enter password: ");
            String passWord = scan.nextLine();

            while (passWord.length() < 8) {
                System.out.print("Invalid, Enter password: ");
                passWord = scan.nextLine();
            }
            String confirmPass = null;
            boolean valid;

            do {

                System.out.print("Confirm password: ");
                String temp = scan.nextLine();
                try {
                    if (temp.equals(passWord)) {
                        valid = true;
                        this.password = temp;
                        confirmPass = temp;
                    } else {

                        throw new MyException("Not Match, Confirm password: ");
                    }
                } catch (MyException e) {
//                    System.out.print("");
                }

            } while (this.password == null);
            
            writer.write(accId + "\t" + userName + "\t" + passWord);
            writer.newLine();
            writer.close();

        } catch (NullPointerException e) {

        }
    }

    public int setId() throws FileNotFoundException, IOException {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader("C:\\Users\\2ndyrGroupC\\Documents\\NetBeansProjects\\account.txt"));
        String line = reader.readLine();
        while (line != null) {
            ++id;
            ++accId;
            line = reader.readLine();
        }
        reader.close();
        return id;
    }
}
