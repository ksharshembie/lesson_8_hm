package kg.geektech.game.players;

import kg.geektech.game.classes.GameEntity;
import kg.geektech.game.classes.HavingSuperAbility;
import kg.geektech.game.classes.Hero;
import kg.geektech.game.general.RPG_Game;

public class Boss extends GameEntity implements HavingSuperAbility {
    private boolean isBossOut = false;
    private final int originHealth;
    static int druidAssist;

    public Boss(int health, int damage) {
        super(health, damage);
        this.originHealth = health;
    }

    public boolean isBossOut() {
        return isBossOut;
    }

    public void setBossOut(boolean bossOut) {
        isBossOut = bossOut;
    }

    public int getOriginHealth() {
        return originHealth;
    }

    public void hit(Hero[] heroes) {
        if (!isBossOut) {
            if (this.getHealth() > 0) {
                for (Hero druid : heroes) {
                    if (druid instanceof Druid) {
                        druidAssist = ((Druid) druid).getCrow();
                    }
                }
                for (Hero player : heroes) {
                    if (player.getHealth() > 0) {
                        if (player instanceof Berserk) {
                            player.setHealth(player.getHealth()
                                    - this.getDamage() / 2 - druidAssist);
                            ((Berserk) player).setSaved_damage(this.getDamage() / 2 - druidAssist);
                        } else if (player instanceof Avrora && ((Avrora) player).isInvisible()) {
                            ((Avrora) player).setSavedDamage(((Avrora) player).getSavedDamage()
                                    + this.getDamage() + druidAssist);
                        } else {
                            player.setHealth(player.getHealth()
                                    - this.getDamage() - druidAssist);
                        }
                    }

                }
            }
        } else {
            System.out.println("Boss stunned");
        }
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!isBossOut) {
            if (RPG_Game.random.nextBoolean()) {
                for (Hero player : heroes) {
                    if (player.getHealth() > 0) {
                        if (RPG_Game.random.nextBoolean()) {
                            player.setHealth(0);
                            System.out.println("\tBoss killed " + player.getClass().getSimpleName());
                            break;
                        }
                    }
                }
            }
        }
    }
}
