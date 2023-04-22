package by.bntu.fitr.poisit.matnik.university.view;

import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.logic.Manager;
import by.bntu.fitr.poisit.matnik.university.model.logic.Sorter;
import by.bntu.fitr.poisit.matnik.university.util.HeroCreator;
import by.bntu.fitr.poisit.matnik.university.util.HeroInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<Hero> heroes;
    public static void showMenu(){
        String choice = "1";
        while (!choice.equals("0")){
            System.out.println("Menu");
            System.out.println("1. Create heroes");
            System.out.println("2. Sort by name and level");
            System.out.println("3. Sort by level");
            System.out.println("4. Sort by build cost");
            System.out.println("5. Find by name");
            System.out.println("6. Find by level");
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next();
            switch (choice){
                case "1":
                    System.out.println("Enter the amount of heroes:");
                    int count = scanner.nextInt();
                    heroes = HeroCreator.create(count);
                    heroes = HeroInitializer.initialize(heroes, count);
                    for (Hero hero : heroes){
                        Printer.print(hero);
                        Printer.printStats(Manager.getStats(hero));
                    }
                    break;
                case "2":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    heroes = Sorter.sortByName(heroes);
                    for (Hero hero : heroes){
                        Printer.print(hero);
                        Printer.printStats(Manager.getStats(hero));
                    }
                    break;
                case "3":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    heroes = Sorter.sortByLevelName(heroes);
                    for (Hero hero : heroes){
                        Printer.print(hero);
                        Printer.printStats(Manager.getStats(hero));
                    }
                    break;
                case "4":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    heroes = Sorter.sortByBuildCost(heroes);
                    for (Hero hero : heroes){
                        Printer.print(hero);
                        Printer.printStats(Manager.getStats(hero));
                    }
                    break;
                case "5":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    System.out.println("Enter the name: ");
                    String name = scanner.next();
                    Printer.print(Manager.findHeroesByName(heroes, name));
                    break;
                case "6":
                    if (heroes == null) {
                        System.out.println("The list is empty!");
                        break;
                    }
                    System.out.println("Enter the name: ");
                    int level = scanner.nextInt();
                    Printer.print(Manager.findHeroesByLevel(heroes, level));
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }
}
