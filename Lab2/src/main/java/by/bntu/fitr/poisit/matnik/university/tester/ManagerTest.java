package main.java.by.bntu.fitr.poisit.matnik.university.tester;



import entity.Artifact;
import entity.Assassin;
import entity.Hero;
import entity.Support;
import main.java.by.bntu.fitr.poisit.matnik.university.logic.Manager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void getStats() {
        Manager manager = new Manager();
        Hero myHero = new Assassin("Alex", 12, "Goblin",
                Arrays.asList(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 700))));
        List<Integer> actual = Arrays.asList(2, 5, 2, 0, 2, 5, 700);
        List<Integer> expected = manager.getStats(myHero);
        assertEquals(expected, actual);
    }

    @Test
    void getMoreStats() {
        List<Artifact> artifacts = new ArrayList<>();
        Hero myHero;
        Manager manager = new Manager();
        artifacts.add(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 700)));
        artifacts.add(new Artifact("Bracer", Arrays.asList(5, 2, 2, 0, 2, 5, 260)));
        artifacts.add(new Artifact("Null Talisman", Arrays.asList(2, 2, 5, 0, 2, 5, 120)));
        artifacts.add(new Artifact("Boots of Speed", Arrays.asList(0, 0, 0, 45, 0, 0, 300)));
        myHero = new Assassin("Alex", 12, "Goblin", artifacts);
        List<Integer> actual = Arrays.asList(9, 9, 9, 45, 6, 15, 1380);
        List<Integer> expected = manager.getStats(myHero);
        assertEquals(expected, actual);
    }

    @Test
    void getNullStats() {
        Hero myHero;
        Manager manager = new Manager();
        myHero = new Support("Alex", 12, "Goblin", null);
        List<Integer> expected = manager.getStats(myHero);
        assertNull(expected);
    }

    @Test
    void getNullHero() {
        Hero myHero = null;
        Manager manager = new Manager();
        List<Integer> expected = manager.getStats(myHero);
        assertNull(expected);
    }

}