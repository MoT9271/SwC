package by.bntu.fitr.poisit.matnik.university.view;

import java.util.List;

public class Printer {
    public static void print(Object msg) {
        System.out.print(msg+ "\r\n");
    }
    public static void printStats(List<Integer> stats){
        System.out.printf("Stats:\r\nstrength " + stats.get(0) + " agility " + stats.get(1) + " intelligence " + stats.get(2) + " movement speed " + stats.get(3) + " armor " + stats.get(4) + " attack speed " + stats.get(5) + " cost " + stats.get(6) + "\n" + "\n");
    }
}