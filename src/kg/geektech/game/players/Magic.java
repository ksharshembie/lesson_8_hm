package kg.geektech.game.players;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;
import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    private int magicBoost;

    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    public int getMagicBoost() {
        return magicBoost;
    }

    public void setMagicBoost(int magicBoost) {
        this.magicBoost = magicBoost;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        magicBoost = RPG_Game.random.nextInt(10);
        System.out.println("Magic boost: " + magicBoost);
        for (Hero player : heroes) {
            if (player.getHealth() > 0) {
                player.setDamage(player.getDamage() + magicBoost);
                System.out.println("\tNew damage of " + player.getClass().getSimpleName() + ": " + player.getDamage());
            }
        }
    }
}
