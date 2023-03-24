package by.bntu.fitr.poisit.matnik.university.model.entity;

import java.util.Arrays;

public class Artifact {
    String type;
    int [] stats;
    public Artifact(String type, int[] stats){
        this.type = type;
        this.stats = stats;
    }

    public Artifact(){
        this("Wraith Band", new int[]{2, 5, 2, 0, 2, 5, 700});
    }


    public String getType() {
        return type;
    }

    public int[] getStats() {
        return stats;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Artifact" +
                "type='" + type + '\'' +
                ", stats: " + "strength " + stats[0] + ", agility " + stats[1] + ", intelligence " + stats[2]
                + ", movement speed " + stats[3] + ", armor" + stats[4] + ", attack speed " + stats[5] + ", cost " + stats[6] + '\n';
    }
}
