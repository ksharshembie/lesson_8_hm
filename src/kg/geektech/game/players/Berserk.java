package kg.geektech.game.players;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;

public class Berserk extends Hero {
    private int saved_damage;

    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        //this logic is realized in hit method
    }

    public int getSaved_damage() {
        return saved_damage;
    }

    public void setSaved_damage(int saved_damage) {
        this.saved_damage = saved_damage;
    }

    public void hit(Boss boss) {
        if (this.getHealth() > 0 && boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth()
                    - this.getDamage() - this.getSaved_damage());
        }
    }
}