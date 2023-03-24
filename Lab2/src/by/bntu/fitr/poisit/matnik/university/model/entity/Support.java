package by.bntu.fitr.poisit.matnik.university.model.entity;
import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.entity.Abilities;

import java.util.Arrays;

public class Support extends Hero{
    Abilities[] abilities;
    public Support(String name, int level, String race, Artifact[] artifacts){
        super(name, level, race, artifacts);
        abilities = new Abilities[]{Abilities.HEAL, Abilities.STUN};
    }

    public void setAbilities(Abilities[] abilities) {
        this.abilities = abilities;
    }

    public Abilities[] getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return "Support{" +
                "abilities=" + Arrays.toString(abilities) +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", \nartifacts=" + Arrays.toString(artifacts) +
                ", level=" + level +
                '}'+ "\n";
    }
}
