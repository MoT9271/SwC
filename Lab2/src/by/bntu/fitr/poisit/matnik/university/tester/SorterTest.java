package by.bntu.fitr.poisit.matnik.university.tester;

import by.bntu.fitr.poisit.matnik.university.model.entity.*;
import by.bntu.fitr.poisit.matnik.university.model.logic.Sorter;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class SorterTest {

    @Test
    public void testSortByLevel() {
        Hero hero1 = new Tank("A", 1, "B", null);
        Hero hero2 = new Assassin("B", 2, "B", null);
        Hero hero3 = new Support("C", 3, "B", null);
        Hero[] heroes = {hero3, hero1, hero2};
        Hero[] sorted = Sorter.sortByLevel(heroes);
        assertEquals(hero1, sorted[0]);
        assertEquals(hero2, sorted[1]);
        assertEquals(hero3, sorted[2]);
    }

    @Test
    public void testSortByName() {
        Hero hero1 = new Tank("A", 1, "B", null);
        Hero hero2 = new Assassin("B", 2, "B", null);
        Hero hero3 = new Support("C", 3, "B", null);
        Hero[] heroes = {hero3, hero1, hero2};
        Hero[] sorted = Sorter.sortByName(heroes);
        assertEquals(hero1, sorted[0]);
        assertEquals(hero2, sorted[1]);
        assertEquals(hero3, sorted[2]);
    }

    @Test
    public void testSortByBuildCost() {
        Hero hero1 = new Assassin("A", 1, "B",new Artifact[]{new Artifact("Wraith Band",   new int[]{2, 5, 2, 0, 2, 5, 700})});
        Hero hero2 = new Tank("B", 2, "B", new Artifact[]{new Artifact("Wraith Band",   new int[]{2, 5, 2, 0, 2, 5, 800})});
        Hero hero3 = new Support("C", 3, "B", new Artifact[]{new Artifact("Wraith Band",   new int[]{2, 5, 2, 0, 2, 5, 900})});
        Hero[] heroes = {hero3, hero1, hero2};
        Hero[] sorted = Sorter.sortByBuildCost(heroes);
        assertEquals(hero1, sorted[0]);
        assertEquals(hero2, sorted[1]);
        assertEquals(hero3, sorted[2]);
    }
}