
import java.awt.*;
import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Grade {

    public static void main(String[] args) {

        Scanner gradeScan= new Scanner(System.in);

        int grade=0;

        System.out.print("Enter your grade=>");
            int gradeNumber= gradeScan.nextInt();

            if (gradeNumber>=90) {
                System.out.println("Your grade is an A!");
            }
            else if (gradeNumber<=65){
                System.out.println("Your grade is an F!");
            }


    }
}
