package by.bntu.fitr.poisit.matnik.university.tester;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import by.bntu.fitr.poisit.matnik.university.model.entity.*;
import by.bntu.fitr.poisit.matnik.university.model.logic.Sorter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SorterTest {
    @Test
    public void testSortByLevelName() {
        Hero hero1 = new Tank("B", 2, "B", null);
        Hero hero2 = new Assassin("A", 2, "B", null);
        Hero hero3 = new Support("C", 3, "B", null);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero3);
        heroes.add(hero1);
        heroes.add(hero2);
        List<Hero> sorted = Sorter.sortByLevelName(heroes);
        assertEquals(hero2, sorted.get(0));
        assertEquals(hero1, sorted.get(1));
        assertEquals(hero3, sorted.get(2));
    }

    @Test
    public void testSortByName() {
        Hero hero1 = new Tank("A", 1, "B", null);
        Hero hero2 = new Assassin("B", 2, "B", null);
        Hero hero3 = new Support("C", 3, "B", null);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero3);
        heroes.add(hero1);
        heroes.add(hero2);
        List<Hero> sorted = Sorter.sortByName(heroes);
        assertEquals(hero1, sorted.get(0));
        assertEquals(hero2, sorted.get(1));
        assertEquals(hero3, sorted.get(2));
    }

    @Test
    public void testSortByBuildCost() {
        List<Artifact> artifacts1 = new ArrayList<>();
        artifacts1.add(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 800)));
        Hero hero1 = new Assassin("A", 1, "B", artifacts1);
        List<Artifact> artifacts2 = new ArrayList<>();
        artifacts2.add(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 700)));
        Hero hero2 = new Assassin("A", 1, "B", artifacts2);
        List<Hero> heroes = new ArrayList<>();
        List<Artifact> artifacts3 = new ArrayList<>();
        artifacts3.add(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 900)));
        Hero hero3 = new Assassin("A", 1, "B", artifacts3);
        heroes.add(hero3);
        heroes.add(hero1);
        heroes.add(hero2);
        List<Hero> sorted = Sorter.sortByBuildCost(heroes);
        assertEquals(hero2, sorted.get(0));
        assertEquals(hero1, sorted.get(1));
        assertEquals(hero3, sorted.get(2));
    }
}