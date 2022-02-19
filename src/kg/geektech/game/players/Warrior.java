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
        int coeff = RPG_Game.random.nextInt(3) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * (coeff - 1));
            System.out.println("\tadditional damage: "+ (this.getDamage() * (coeff - 1)) + "[coeff=" + coeff + "]");
    }
}
