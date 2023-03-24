package by.bntu.fitr.poisit.matnik.university.util;

import by.bntu.fitr.poisit.matnik.university.model.entity.Artifact;
import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;

import java.util.Random;

public class HeroCreator {

    public  static Hero[] create(int size){
        Hero[] heroes = new Hero[size];
        for (int i = 0; i < size; i++){
            heroes[i] = new Hero();
        }
        return heroes;
    }


}
