import java.util.Random;

class Dice {
    static Random rand = new Random();

    public static int rollDice() {
        return rand.nextInt(6) + 1;

    }
}