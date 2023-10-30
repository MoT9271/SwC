package main.java.by.bntu.fitr.poisit.matnik.university.util;


import entity.Artifact;
import entity.Assassin;
import entity.Hero;

import java.util.List;

public class AssassinFactory implements HeroFactory {
    @Override
    public Hero createHero(String name, int level, String race, List<Artifact> artifacts) {
        return new Assassin(name, level, race, artifacts);
    }
}