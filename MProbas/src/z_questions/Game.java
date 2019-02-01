package z_questions;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

    Scanner input =  new Scanner(System.in);
    input.useDelimiter("[,\n]");
    System.out.println("Enter size of array and case, separated by comma: ");

    final int MAXSIZE = input.nextInt();
    String transformation = input.next();
    int arrayList[] = new int[MAXSIZE +1];
    for (int i = 0; i < arrayList.length; i++) {
           arrayList[i] = i;
       }

    for(int i = 0; i<arrayList.length; i++) {
           System.out.print(arrayList[i] + "\n");
    }
    System.out.print(transformation);

    cases(transformation, arrayList);

    }

    public static void caseDouble(String transformation, int[] arrayList) {
           for(int i = 1; i<arrayList.length; i++) {
               arrayList[i] = arrayList[i]*2;
           }   
           for(int i = 1; i<arrayList.length; i++) {
               System.out.print(arrayList[i] + "\n");
        }

    }
    public static void caseAccumulate(String transformation, int[] arrayList) {
           int total = 0;
           for (int i = 1; i<arrayList.length; i++) {
               total += arrayList[i]/arrayList.length;
               System.out.println(arrayList[total]);   
           }
       }
    public static void caseAbsolute(String transformation, int[] arrayList) {
        for(int i = 1; i<arrayList.length;i++) {
            System.out.print(Math.abs(arrayList[i]));
        }
    }
    public static void caseHalve(String transformation, int[] arrayList) {
        for(int i = 1; i<arrayList.length;i++) {
            System.out.print(arrayList[i]/2);
        }
    }

    public static int[] cases(String transformation, int[] arrayList) {
        switch(transformation) {
        case "absolute":
            caseAbsolute(transformation, arrayList);
                break;
        case "halve":
            caseHalve(transformation, arrayList);
                break;
        case "accumulate":
            caseAccumulate(transformation, arrayList);
               break;
        case "double":
            caseDouble(transformation, arrayList);
        }
        return arrayList;
        
    }
    
}
        
