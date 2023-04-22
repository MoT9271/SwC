package by.bntu.fitr.poisit.matnik.university.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Support extends Hero {
    List<Abilities> abilities;

    public Support(String name, int level, String race, List<Artifact> artifacts) {
        super(name, level, race, artifacts);
        abilities = new ArrayList<>();
        abilities.add(Abilities.HEAL);
        abilities.add(Abilities.STUN);
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return "Support{" +
                "abilities=" + abilities +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", \nartifacts=" + artifacts +
                ", level=" + level +
                "}\n";
    }
}
