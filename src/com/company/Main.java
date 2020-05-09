package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 750;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int medicHealth = 200;
    public static int medicTreatment = 30;
    public static String medicAbilities = "Medical";
    public static int[] heroesHealth = {260, 250, 240};
    public static int[] heroesDamage = {20, 15, 25};
    public static String[] heroesSuperAbilities = {"Physical", "Magical", "Kinetic"};
    public static int roundNumber = 1;

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesSuperAbilities.length);
        bossDefenceType = heroesSuperAbilities[randomIndex];
    }

    public static void MedicTreatment() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesHealth.length);
        medicAbilities = heroesSuperAbilities[randomIndex];
    }


    public static void main(String[] args) {
        printStatistics();
        System.out.println("################################");
        while (!isGameFinished()) {
            System.out.println("Round" + roundNumber);
            round();
        }
    }

    public static void round() {
        changeBossDefence();
        bossHit();
        heroesHit();
        medicTreatment();
        printStatistics();
        roundNumber++;
    }

    private static void medicTreatment() {
    }

    private static void bossHit() {
    }

    private static void heroesHit() {
    }


    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        if (medicHealth <= 0) {
            System.out.println("Medic died!");
            return true;

        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead) {
            System.out.println("Boss won!");
        }
        return allHeroesDead;
    }

    public static void printStatistics() {
        System.out.println("------------------------------------------");
        System.out.println("Boss health:" + bossHealth);
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesSuperAbilities[i] + "health:" + heroesHealth[i]);
            System.out.println("Medic health:" + medicHealth);
            for (int j = 0; j < heroesHealth.length; j++) {
                System.out.println(heroesSuperAbilities[i] + "health" + heroesHealth[i]);

            }
            System.out.println("---------------------------------------");


        }
        public static void heroesHit(){
            for (int i = 0; i < heroesDamage.length; i++) {
                if (heroesHealth[i] > 0) {
                    if (bossDefenceType == heroesSuperAbilities[i]) {
                        Random r = new Random();
                        int coef = r.nextInt(10);
                        System.out.println(heroesSuperAbilities[i] + "hit boss with critical damage" +
                                heroesDamage[i] * coef);
                        if (bossHealth - heroesDamage[i] * coef < 0) {
                            bossHealth = 0;
                        } else {
                            if (bossHealth - heroesDamage[i] < 0) {
                                bossHealth = 0;
                            } else {
                                bossHealth = bossHealth - heroesDamage[i];
                            }
                        }
                    }
                }

            }
        }
            public static void medicTreatment () {
                for (int i = 0; i < heroesHealth.length; i++) {
                    if (heroesHealth[i] <= 100) {
                        if (medicHealth == heroesHealth[i]) {
                            Random r = new Random();
                            int coef = r.nextInt(3);
                            System.out.println(heroesHealth[i] + "medic treatment player" +
                                    heroesHealth[i] * coef);
                            if (medicHealth - heroesHealth[i] * coef < 0) ;
                            medicHealth = 0;
                        } else {
                            if (medicHealth - heroesHealth[i] < 0) {
                                medicHealth = 0;
                            } else {
                                medicHealth = medicHealth - heroesHealth[i];
                            }
                        }
                    }

                }
            }
            public static void bossHit () {
                for (int i = 0; i < heroesHealth.length; i++) {
                    if (bossHealth > 0) {
                        if (heroesHealth[i] > 0) {
                            if (bossHealth > medicHealth) {
                                medicHealth = 0;
                            } else {
                                medicHealth = medicHealth - bossDamage;
                            }
                        }
                        if (heroesHealth[i] - bossDamage < 0) {
                            heroesHealth[i] = 0;
                        } else {
                            heroesHealth[i] = heroesHealth[i] - bossDamage;
                        }
                    }

                }
            }
        }
}
