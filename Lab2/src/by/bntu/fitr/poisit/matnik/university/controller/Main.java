package by.bntu.fitr.poisit.matnik.university.controller;
import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.logic.Manager;
import by.bntu.fitr.poisit.matnik.university.view.Printer;
import by.bntu.fitr.poisit.matnik.university.util.HeroCreator;
import by.bntu.fitr.poisit.matnik.university.util.HeroInitializer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the amount of heroes:");
        int count = in.nextInt();
        Hero[] heroes = HeroCreator.create(count);
        HeroInitializer.initialize(heroes);
        Printer.print(Arrays.toString(heroes));

    }




}
