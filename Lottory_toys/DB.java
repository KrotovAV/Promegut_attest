package Lottory_toys;

import java.util.ArrayList;

public class DB {
    ArrayList<Toy> toys = new ArrayList<>();
    
    public DB() {
    }

    public static void addToyToArrayList(ArrayList<Toy> toys, Toy toy) {
        toys.add(toy);
        Write.writeFile("Add Toy: " 
        + String.valueOf(toy.getToyID()) + ":" 
        + String.valueOf(toy.getName()) + " (" 
        + String.valueOf(toy.getAvailable()) + " Units, " 
        + String.valueOf(toy.getFrequency()) +  " freq)");
    }

    public static void printList(ArrayList<Toy> toys) {
        for (int i = 0; i < toys.size(); i++) {
            toys.get(i).print();
            Write.writeFile("Print ArrayList<Toy> toys:  " 
            + String.valueOf(toys.get(i).getToyID()) + ":" 
            + String.valueOf(toys.get(i).getName()) + " (" 
            + String.valueOf(toys.get(i).getAvailable()) + " Units, " 
            + String.valueOf(toys.get(i).getFrequency()) +  " freq)");
        }
    }

    public static int checkAvailable(ArrayList<Toy> toys) {
        int check = 0;
        for (int i = 0; i < toys.size(); i++) {
            check = check + toys.get(i).getAvailable();
        }
        Write.writeFile("check Available ArrayList<Toy> toys: " + String.valueOf(check));
        return check;
    }
    
    public static int checkUnique(ArrayList<Toy> toys) {
        int check = toys.size();
        Write.writeFile("check Unique ArrayList<Toy>: " + String.valueOf(check));
        return check;
    }

    public static double checkMax(ArrayList<Double> arr) {
        double max = arr.get(arr.size() - 1);
        Write.writeFile("check Max ArrayList<Double> arr: " + String.valueOf(max));
        return max;
    }

    public static ArrayList<Toy> correctArrayList(ArrayList<Toy> toys, Toy toy) {
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i) == toy) {
                int newAvailable = toys.get(i).getAvailable() - 1;
                toys.get(i).setAvailable(newAvailable);
            }
            Write.writeFile("correct ArrayList ArrayList<Toy> toys: " 
            + String.valueOf(toys.get(i).getToyID()) + ":" 
            + String.valueOf(toys.get(i).getName()) + " (" 
            + String.valueOf(toys.get(i).getAvailable()) + " Units, " 
            + String.valueOf(toys.get(i).getFrequency()) +  " freq)");
        }
        return toys;
    }


    public static ArrayList<Double> lotteryArr(ArrayList<Toy> toys) {
        ArrayList<Double> intervals = new ArrayList<>();
        double interSum = toys.get(0).getFrequency();
        intervals.add(interSum);
        for (int i = 1; i < toys.size(); i++) {
            interSum = interSum + toys.get(i).getFrequency();
            intervals.add(interSum);
        }
        Write.writeFile("lottery Arr ArrayList<Double> intervals: " + String.valueOf(intervals));
        return intervals;
    }

    public static Toy lottery(ArrayList<Toy> toys, ArrayList<Double> intervals, double nam) {
        double d = 0;
        intervals.add(0, d);
        Toy prize = toys.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i-1) < nam && nam <= intervals.get(i)) {
                prize = toys.get(i-1);
            }
        }
        Write.writeFile("lottery toys intervals nam: " + String.valueOf(prize));
        return prize;
    }

}