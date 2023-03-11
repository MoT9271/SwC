package by.bntu.fitr.poisit.matnik.university.view;

public class Printer {
    public static void print(Object msg) {
        System.out.print(msg+ "\r\n");
    }

    public static void printStats(int [] stats){
        System.out.printf("Stats:\r\nstrength " + stats[0] + " agility " + stats[1] + " intelligence " +  stats[2] + " movement speed " + stats[3] + " armor " + stats[4] + " attack speed " + stats[5] + " cost " + stats[6] + "\r\n");
    }
}
