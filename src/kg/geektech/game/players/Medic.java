package kg.geektech.game.players;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
            System.out.println(this.getClass().getSimpleName() + " treat:");
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 &&
                        this != heroes[i]) {
                    System.out.println("\t" + heroes[i].getClass().getSimpleName()
                            + " from: " + heroes[i].getHealth()
                            + " to: " + (heroes[i].getHealth() + this.healPoints));
                    heroes[i].setHealth(heroes[i].getHealth() + this.healPoints);
                }
            }
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }
}
