package kg.geektech.game.players;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.classes.SuperAbility;
import kg.geektech.game.general.RPG_Game;

public class Druid extends Hero {
    private static boolean isAssist = false;
    private int angel;
    private int crow;


    public Druid(int health, int damage) {
        super(health, damage, SuperAbility.DRUID);
    }

    public int getAngel() {
        return angel;
    }


    public int getCrow() {
        return crow;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!isAssist) {
            boolean applyAssist = RPG_Game.random.nextBoolean();
            if (applyAssist) {
                boolean assist;
                assist = RPG_Game.random.nextBoolean();
                if (assist) {
                    this.angel = RPG_Game.random.nextInt(10);
                    System.out.println("\t Druid assists to Medic to " + this.getAngel());
                    isAssist = true;
                } else {
                    this.angel = 0;
                    if (boss.getHealth() < (boss.getOriginHealth() / 2)) {
                        this.crow = boss.getDamage() / 2;
                        System.out.println("\t Druid assists to Boss");
                        isAssist = true;
                    } else {
                        this.crow = 0;
                    }
                }
            }
        }
    }
}
