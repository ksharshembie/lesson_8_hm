package kg.geektech.game.players;

import kg.geektech.game.classes.GameEntity;
import kg.geektech.game.classes.Hero;

public class Boss extends GameEntity {
    private boolean isBossOut = false;

    public Boss(int health, int damage) {
        super(health, damage);
    }

    public boolean isBossOut() {
        return isBossOut;
    }

    public void setBossOut(boolean bossOut) {
        isBossOut = bossOut;
    }

    public void hit(Hero[] heroes) {
        if (!isBossOut) {
            if (this.getHealth() > 0) {
                for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getHealth() > 0) {
                        if (heroes[i] instanceof Berserk) {
                            heroes[i].setHealth(heroes[i].getHealth()
                                    - this.getDamage() / 2);
                            ((Berserk) heroes[i]).setSaved_damage(this.getDamage() / 2);
                        } else {
                            heroes[i].setHealth(heroes[i].getHealth()
                                    - this.getDamage());
                        }
                    }
                }
            }
        } else {
            System.out.println("Boss stunned");
        }
    }
}
