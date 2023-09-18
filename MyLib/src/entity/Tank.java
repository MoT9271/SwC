package entity;

import java.util.ArrayList;
import java.util.List;

public class Tank extends Hero {

    List<Abilities> abilities;

    public Tank(String name, int level, String race, List<Artifact> artifacts) {
        super(name, level, race, artifacts);
        abilities = new ArrayList<>();
        abilities.add(Abilities.SHIELDBLOCK);
        abilities.add(Abilities.TAUNT);
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "abilities=" + abilities +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", \nartifacts=" + artifacts +
                ", level=" + level +
                '}' + "\n";
    }
}
