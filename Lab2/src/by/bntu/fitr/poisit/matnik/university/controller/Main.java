package by.bntu.fitr.poisit.matnik.university.controller;
import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.logic.Manager;
import by.bntu.fitr.poisit.matnik.university.view.Printer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the amount of knights:");
        int count = in.nextInt();
        Hero[] heroes = Manager.creatHeroes(count);
        for (int i = 0; i < count; i++){
            Printer.print(heroes[i]);
            Printer.printStats(Manager.getStats(heroes[i]));
        }

    }




}
