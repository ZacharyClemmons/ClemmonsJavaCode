import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Asynch {
    public static void main(String[] args) {

        //declare integer array
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ReverseIntArray(intArray);
        //declare string array
        String[] nameArray = {"Spiderman", "Batman", "Superman", ""};
        ReverseStringArray(nameArray);
        ReverseArrayS(nameArray);
    }

    //reverses and prints integer array.
    public static void ReverseIntArray(Integer x[]) {
        Collections.reverse(Arrays.asList(x));
        System.out.println(Arrays.asList(x));
    }
    //reverses and prints the String array
    public static void ReverseArrayS(String z[]) {
        Collections.reverse(Arrays.asList(z));
        System.out.println(Arrays.asList(z));
    }
    public static void ReverseStringArray(String y[]) {
        //declare variables
        String input1;
        String input2;
        String input3;
        //loop

            input1 = y[0];
            input2=y[1];
            input3=y[2];
            //creates the strinbuffer object :buffy
            StringBuffer buffy= new StringBuffer(input1);
            StringBuffer buffy2= new StringBuffer(input2);
            StringBuffer buffy3= new StringBuffer(input3);
           //reverse the string put into the stringbuffer
            buffy.reverse();
            buffy2.reverse();
            buffy3.reverse();

            input2=buffy.toString();
            //copy to the array
            y[0]=buffy.toString();
            y[1]=buffy2.toString();
            y[2]=buffy3.toString();



    }
}

