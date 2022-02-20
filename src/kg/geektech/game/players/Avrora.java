package kg.geektech.game.players;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;
import kg.geektech.game.general.RPG_Game;

public class Avrora extends Hero {
    private int roundCounter = 2;
    private int savedDamage;
    private boolean isInvisible = false;
    private boolean isPowerApplied = false;

    public Avrora(int health, int damage) {
        super(health, damage, SuperAbility.INVISIBILITY);
    }

    public boolean isInvisible() {
        return isInvisible;
    }

    public int getSavedDamage() {
        return savedDamage;
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!isPowerApplied) {
            if (roundCounter > 0) {
                if (isInvisible) {
                    roundCounter--;
                    System.out.println("\t Avrora is invisible, saved damage: " + this.savedDamage);
                } else {
                    isInvisible = RPG_Game.random.nextBoolean();
                }
            } else {
                boss.setHealth(boss.getHealth() - this.savedDamage);
                System.out.println("\t Avrora set Super Damage:" + this.savedDamage);
                isPowerApplied = true;
            }
        }
    }
}

