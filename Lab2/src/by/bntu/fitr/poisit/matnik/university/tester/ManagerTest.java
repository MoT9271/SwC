package by.bntu.fitr.poisit.matnik.university.tester;

import by.bntu.fitr.poisit.matnik.university.model.entity.Artifact;
import by.bntu.fitr.poisit.matnik.university.model.entity.Assassin;
import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.entity.Support;
import by.bntu.fitr.poisit.matnik.university.model.logic.Manager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void getStats() {
        Hero myHero = new Assassin("Alex", 12, "Goblin", new Artifact[]{new Artifact("Wraith Band", new int[]{2, 5, 2, 0, 2, 5, 700})});
        int[] actual = new int[]{2, 5, 2, 0, 2, 5, 700};
        int[] expected = Manager.getStats(myHero);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getMoreStats() {
        Artifact[]  artifacts = new Artifact[4];
        Hero myHero;
        artifacts[0] = new Artifact("Wraith Band",   new int[]{2, 5, 2, 0, 2, 5, 700});
        artifacts[1] = new Artifact("Bracer",        new int[]{5, 2, 2, 0, 2, 5, 260});
        artifacts[2] = new Artifact("Null Talisman", new int[]{2, 2, 5, 0, 2, 5, 120});
        artifacts[3] = new Artifact("Boots of Speed",new int[]{0, 0, 0, 45, 0, 0, 300});
        myHero = new Assassin("Alex", 12, "Goblin", artifacts);
        int[] actual = new int[]{9, 9, 9, 45, 6, 15, 1380};
        int[] expected = Manager.getStats(myHero);
        assertArrayEquals(expected, actual);
    }
    @Test
    void getNullStats() {
        Hero myHero;
        myHero = new Support("Alex", 12, "Goblin", null);
        int[] expected = Manager.getStats(myHero);
        assertNull(expected);
    }
    @Test
    void getNullHero() {
        Hero myHero = null;
        int[] expected = Manager.getStats(myHero);
        assertNull(expected);
    }

}