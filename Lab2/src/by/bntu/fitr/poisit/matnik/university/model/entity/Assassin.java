package by.bntu.fitr.poisit.matnik.university.model.entity;

import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.entity.Abilities;

import java.util.Arrays;
import java.util.List;

public class Assassin extends Hero {
    List<Abilities> abilities;

    public Assassin(String name, int level, String race, List<Artifact> artifacts) {
        super(name, level, race, artifacts);
        abilities = Arrays.asList(Abilities.BLINK, Abilities.INVISIBILITY);
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return "Assassin{" +
                "abilities=" + abilities +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", \nartifacts=" + artifacts +
                ", level=" + level +
                '}' + "\n";
    }
}