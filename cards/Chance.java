import java.util.Random;

public class Chance extends Squares {

    private static final String[] CHANCE_CARDS = {
            "Advance to Go (Collect $200)",
            "Bank pays you dividend of $50",
            "Go directly to Jail (Do not pass Go, Do not collect $200)",
            "Collect a random number of money",
    };

    private Random random;

    private String chanceCardSelected = "";

    public Chance(int position, String name, String pseudo) {
        super(position, name, pseudo);
        this.random = new Random();
        this.chanceCardSelected = "";
    }

    @Override
    public void task(Player player) {
        String chanceCard = drawChanceCard();
        this.chanceCardSelected = chanceCard;
        switch (chanceCard) {
            case "Advance to Go (Collect $200)":
                player.setPosition(0);
                player.increaseMoney(200);
                break;
            case "Bank pays you dividend of $50":
                player.increaseMoney(50);
                break;
            case "Go directly to Jail (Do not pass Go, Do not collect $200)":
                player.setPosition(10);
                break;
            case "collect a random number of money":
                int money = random.nextInt(1000) + 50;
                player.increaseMoney(money);
                this.chanceCardSelected = String.format("you have won %s $", money);
                break;
        }
    }

    private String drawChanceCard() {
        return CHANCE_CARDS[random.nextInt(CHANCE_CARDS.length)];
    }

    @Override
    public String toString() {
        return "Chance [CHANCE_CARDS=" + this.chanceCardSelected + "]";
    }

}
