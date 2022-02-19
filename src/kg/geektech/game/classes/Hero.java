package kg.geektech.game.classes;

import kg.geektech.game.players.Boss;

public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private SuperAbility ability;

    public Hero(int health, int damage, SuperAbility ability) {
        super(health, damage);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void setAbility(SuperAbility ability) {
        this.ability = ability;
    }

    public void hit(Boss boss) {
            boss.setHealth(boss.getHealth() - this.getDamage());
            System.out.println(this.getClass().getSimpleName() + " set damage: " + this.getDamage());
    }
}
