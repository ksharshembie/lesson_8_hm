package kg.geektech.game.general;

import kg.geektech.game.classes.Hero;
import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1500, 50);
        Warrior warrior = new Warrior(270, 10);
        Medic doc = new Medic(200, 5, 15);
        Magic magic = new Magic(290, 20);
        Berserk berserk = new Berserk(260, 15);
        Medic junior = new Medic(250, 10, 5);
        Thor thor = new Thor(300, 25);
        Witcher witcher = new Witcher(250, 20);
        Druid druid = new Druid(230, 20);
        Avrora avrora = new Avrora(220, 10);
        Hero[] heroes = {warrior, doc, magic, berserk, junior, thor, witcher, druid, avrora};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
            printStatistics(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        round_number++;
        System.out.println(round_number + " ROUND START___________");
        System.out.println("Boss's turn");
        boss.hit(heroes);
        boss.applySuperPower(boss, heroes);
        System.out.println("-----------------------");
        System.out.println("Hero's turn");
        for (Hero player : heroes) {
            if (player.getHealth() > 0 && boss.getHealth() > 0) {
                player.hit(boss);
            }
            if (!(player instanceof Magic) && player.getHealth() > 0 && boss.getHealth() > 0) {
                player.applySuperPower(boss, heroes);
            }
            if (boss.getHealth() == 0) {
                System.out.println(player.getClass().getSimpleName() + " killed Boss");
                break;
            }
        }
        for (Hero player : heroes) {
            if (player instanceof Magic && player.getHealth() > 0 && boss.getHealth() > 0) {
                player.applySuperPower(boss, heroes);
            }
        }

        System.out.println("_________________________");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("\n\tHeroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero player : heroes) {
            if (player.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("\n\tBoss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("\n*** HEALTH STATISTICS ***");
        System.out.println("Boss health: " + boss.getHealth() + " [" +
                boss.getDamage() + "]");
        for (Hero player : heroes) {
            if (player instanceof Medic) {
                System.out.println(player.getClass().getSimpleName()
                        + " health: " + player.getHealth() + " [" +
                        player.getDamage() + "] +"
                        + ((Medic) player).getHealPoints() + "+");
            } else {
                System.out.println(player.getClass().getSimpleName()
                        + " health: " + player.getHealth() + " [" +
                        player.getDamage() + "]");
            }
        }
        System.out.println("*************************\n");
    }
}
