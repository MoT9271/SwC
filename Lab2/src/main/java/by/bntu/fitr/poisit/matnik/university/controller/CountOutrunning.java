package main.java.by.bntu.fitr.poisit.matnik.university.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountOutrunning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cars on the track: ");
        int n = scanner.nextInt();

        List<Integer> position = new ArrayList<>();
        List<Integer> speed = new ArrayList<>();
        int overtakes = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the starting position of the vehicle " + (i+1) + ": ");
            position.add(scanner.nextInt());
            System.out.print("Enter vehicle speed" + (i+1) + ": ");
            speed.add(scanner.nextInt());
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if ((position.get(i) < position.get(j) && speed.get(i) > speed.get(j)) ||
                        (position.get(i) > position.get(j) && speed.get(i) < speed.get(j))) {
                    overtakes++;
                }
            }
        }

        System.out.println("Number of overtakes: " + overtakes);
    }
}
