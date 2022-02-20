package kg.geektech.game.players;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;
import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {

    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.THUNDER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean isOut = RPG_Game.random.nextBoolean();
        if (boss.isBossOut() && isOut) {
            isOut = false;
        }
        boss.setBossOut(isOut);
        System.out.println("\t" + this.getClass().getSimpleName() + " stunned Boss: " + isOut);

    }
}
