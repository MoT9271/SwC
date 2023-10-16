package entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Assassin extends Hero implements Serializable {
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