package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;
import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(4) + 2;
    }
}
