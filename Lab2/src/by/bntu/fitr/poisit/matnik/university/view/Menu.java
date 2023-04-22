package by.bntu.fitr.poisit.matnik.university.view;
import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.logic.Manager;
import by.bntu.fitr.poisit.matnik.university.model.logic.Sorter;
import by.bntu.fitr.poisit.matnik.university.util.HeroCreator;
import by.bntu.fitr.poisit.matnik.university.util.HeroInitializer;

import java.util.Scanner;

public class Menu {
    static Hero[] heroes;
    public static void showMenu(){
        String choice = "1";
        while (!choice.equals("0")){
            System.out.println("Menu");
            System.out.println("1. Create heroes");
            System.out.println("2. Sort by name");
            System.out.println("3. Sort by level");
            System.out.println("4. Sort by build cost");
            System.out.println("0. Exit\n");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next();
            switch (choice){
                case "1":
                    System.out.println("Enter the amount of heroes:");
                    int count = scanner.nextInt();
                    heroes = HeroCreator.create(count);
                    HeroInitializer.initialize(heroes);
                    for (int i = 0; i < count; i++){
                        Printer.print(heroes[i]);
                        Printer.printStats(Manager.getStats(heroes[i]));
                    }
                    break;
                case "2":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    heroes = Sorter.sortByName(heroes);
                    for (int i = 0; i < heroes.length; i++){
                        Printer.print(heroes[i]);
                        Printer.printStats(Manager.getStats(heroes[i]));
                    }
                    break;
                case "3":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    heroes = Sorter.sortByLevel(heroes);
                    for (int i = 0; i < heroes.length; i++){
                        Printer.print(heroes[i]);
                        Printer.printStats(Manager.getStats(heroes[i]));
                    }
                    break;
                case "4":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    heroes = Sorter.sortByBuildCost(heroes);
                    for (int i = 0; i < heroes.length; i++){
                        Printer.print(heroes[i]);
                        Printer.printStats(Manager.getStats(heroes[i]));
                    }
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }

}
