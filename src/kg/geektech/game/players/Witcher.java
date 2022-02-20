package kg.geektech.game.players;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;

public class Witcher extends Hero {


    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.REVIVAL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero player : heroes) {
            if (player.getHealth() == 0) {
                player.setHealth(player.getOriginHealth());
                this.setHealth(0);
                System.out.println("\t" + this.getClass().getSimpleName() + " revival "
                        + player.getClass().getSimpleName() + " and dead");
                break;
            }
        }
    }
}
