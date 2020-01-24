package Monsters;

import java.util.Random;

abstract public class BaseMonster implements Monster{

    //The heath of the monster
    private int health;

    //The attack of the monster
    private int attack;

    //The defense of the monster
    private int defense;

    //The speed of the monster
    private int speed;

    //Constructor of the monster class
    public BaseMonster(int health, int attack, int defense, int speed){
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    //Return all the stats of the monster
    public int[] getStats(){
        int[] stats = {health, attack, defense, speed};
        return stats;
    }

    //Let the monster do a random action
    public void action(int range){
        Random r = new Random();
        int random = r.nextInt(range);
        if(50 >= random){
            attack();
        }
    }

    public int attack(){
        return attack;
    }
}
