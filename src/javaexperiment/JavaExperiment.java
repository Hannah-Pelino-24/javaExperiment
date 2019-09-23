package javaexperiment;

import java.io.IOException;
import java.util.Scanner;

public class JavaExperiment {

    public static void main(String[] args) throws IOException, Exception {

        account acc = new account();
        personal_Info p = new personal_Info();
        schedule s = new schedule();

        acc.userMenu();
        p.personal_Info(acc.getId(), acc.getAccId());
        s.schedule(acc.getAccId());
    }

}
