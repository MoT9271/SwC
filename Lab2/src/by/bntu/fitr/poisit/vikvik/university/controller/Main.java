package by.bntu.fitr.poisit.vikvik.university.controller;

import by.bntu.fitr.poisit.vikvik.university.model.entity.Knight;
import by.bntu.fitr.poisit.vikvik.university.model.logic.Manager;
import by.bntu.fitr.poisit.vikvik.university.view.Printer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount of knights:x");
        int count = in.nextInt();
        Knight[] knights = Manager.creatHeroes(count);
        for (int i = 0; i < count; i++){
            Printer.print(knights[i]);
        }

    }




}
