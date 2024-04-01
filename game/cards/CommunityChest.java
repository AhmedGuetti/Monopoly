import java.util.Random;

public class CommunityChest extends Squares {

    private static final String[] COMMUNITY_CHEST_CARDS = {
            "Advance to Go (Collect $200)",
            "Bank error in your favor – collect $75",
            "Doctor's fees – Pay $50",
    };

    private Random random;

    private String communityChestCardSelected = "";

    CommunityChest(int position, String name, String pseudo) {
        super(position, name, pseudo);
        this.random = new Random();
        this.communityChestCardSelected = "";
    }

    @Override
    public void task(Player player) {
        int randomIndex = random.nextInt(COMMUNITY_CHEST_CARDS.length);
        String card = COMMUNITY_CHEST_CARDS[randomIndex];
        executeCommunityChestCard(player, card);
        this.communityChestCardSelected = card;
    }

    private void executeCommunityChestCard(Player player, String card) {
        System.out.println("Community Chest Card: " + card);
        if (card.contains("Advance to Go")) {
            player.setPosition(0);
            player.increaseMoney(200);
        } else if (card.contains("Bank error in your favor")) {
            player.increaseMoney(75);
        } else if (card.contains("Doctor's fees")) {
            if (player.getMoney() > 50) {
                player.descreaseMoney(50);
            } else {
                player.descreaseMoney(player.getMoney());
                player.bankRuptcy();
            }
        }
    }

    @Override
    public String toString() {
        return "CommunityChest [COMMUNITY_CHEST_CARDS=" +  this.communityChestCardSelected  + "]";
    }
}
