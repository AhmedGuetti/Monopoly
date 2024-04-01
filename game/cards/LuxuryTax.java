/**
 * LuxuryTax
 */
public class LuxuryTax extends Squares {

    private final int luxuryTaxAmount = 200;

    LuxuryTax(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        if (player.getMoney() > luxuryTaxAmount) {
            player.descreaseMoney(luxuryTaxAmount);
        } else {
            player.descreaseMoney(player.getMoney());
            player.bankRuptcy();
        }
    }
    @Override
    public String toString() {
        return  "LuxuryTax [luxuryTaxAmount=" + luxuryTaxAmount + "]";
    }
}