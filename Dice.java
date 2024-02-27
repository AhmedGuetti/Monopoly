import java.util.Random;

class Dice {
    static Random rand = new Random();

    public static int rollDice(int numberDice){
        return rand.nextInt(7)*numberDice;
    }
}