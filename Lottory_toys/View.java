package Lottory_toys;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    public int getValue(String title) {
        System.out.printf("%s", title);
        return in.nextInt();
    }

    public static void printIntData(int data, String title) {
        System.out.printf("%s%d\n", title, data);
    }

    public static void printDouData(double data, String title) {
        System.out.printf("%s%s\n", title, String.valueOf(data));
    }

    public static void printEmpty() {
        System.out.println();
    }

    public static void printString(String stri) {
        System.out.println(stri);
    }

    public static void printNam(int nam) {
        System.out.println(String.valueOf(nam));
    }
    
    public static void printDouble(double dou) {
        System.out.println(String.valueOf(dou));
    }

    public static void printList(ArrayList<Toy> toys) {
        for (int i = 0; i < toys.size(); i++)
            toys.get(i).print();
    }

    public static void printDoubleArr(ArrayList<Double> arr) {
    System.out.println(arr);
    }
}
