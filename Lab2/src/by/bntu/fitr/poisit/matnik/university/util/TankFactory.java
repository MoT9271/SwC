package by.bntu.fitr.poisit.matnik.university.util;

import entity.Artifact;
import entity.Hero;
import entity.Tank;

import java.util.List;

public class TankFactory implements HeroFactory {
    @Override
    public Hero createHero(String name, int level, String race, List<Artifact> artifacts) {
        return new Tank(name, level, race, artifacts);
    }
}