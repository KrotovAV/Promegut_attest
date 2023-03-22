package Lottory_toys;

import java.util.ArrayList;
import java.util.Random;

public class Controller {

    public static void run() {
        View.printEmpty();

        Toy t1 = new Toy(001, "Чебурашка", 7, 0.11);
        t1.print();
        Toy t2 = new Toy(002, "Гномик", 5, 0.25);
        t2.print();
        Toy t3 = new Toy(003, "Конструктор", 12, 0.15);
        t3.print();
        Toy t4 = new Toy(004, "Супермен плюшевый", 35, 0.85);
        t4.print();

        ArrayList<Toy> toys = new ArrayList<>();
        DB.addToyToArrayList(toys, t1);
        DB.addToyToArrayList(toys, t2);
        DB.addToyToArrayList(toys, t3);
        DB.addToyToArrayList(toys, t4);
        DB.printList(toys);

        View.printString("------------------");
        t4.print();
        View.printEmpty();
        t4.modifyFrequency(0.56);
        t4.print();
        View.printString("------------------");
        DB.printList(toys);

        View.printString("------------------");

        int cheU = DB.checkUnique(toys);
        View.printIntData(cheU, "Доступно видов игрушек: ");

        int cheA = DB.checkAvailable(toys);
        View.printIntData(cheA, "доступно штук игрушек: ");

        ArrayList<Double> lotteryArr = DB.lotteryArr(toys);
        // View.printDoubleArr(lotteryArr);
        
        double max = DB.checkMax(lotteryArr);

        View.printEmpty();
        View.printDouData(max, "Введите число от 0 до ");
        View.printString("------------------");
        
        Random r = new Random();
        double rand = 0 + (max - 0) * r.nextDouble();
        View.printDouble(rand);
        View.printString("------------------");

        Toy prizee;
        if (cheA == 0) {
            View.printString("НЕ возмжно провести лоторею! Игрушки закончились!");
            prizee = new Toy(0, "0", 0, 0);
        }
        else {
            prizee = DB.lottery(toys, lotteryArr, rand);
            prizee.print();
        }

        View.printString("------------------");

        DB.correctArrayList(toys, prizee);
        DB.printList(toys);
        View.printEmpty();

        cheU = DB.checkUnique(toys);
        View.printIntData(cheU, "Доступно видов игрушек: ");
        cheA = DB.checkAvailable(toys);
        View.printIntData(cheA, "доступно штук игрушек: ");
        View.printEmpty();
    }

}
