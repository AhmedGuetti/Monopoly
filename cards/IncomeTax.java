public class IncomeTax extends Squares {

    private final int incomeTaxRate = 17;
    private final int maxIncomeTaxAmount = 300;

    IncomeTax(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        int incomeTaxAmount = calculateIncomeTax(player);
        incomeTaxAmount = Math.min(incomeTaxAmount, maxIncomeTaxAmount);
        if (player.getMoney() > incomeTaxAmount) {
            player.descreaseMoney(incomeTaxAmount);
        } else {
            player.descreaseMoney(player.getMoney());
            player.bankRuptcy();
        }
    }

    private int calculateIncomeTax(Player player) {
        int totalAssets = player.getProperties().size();
        int incomeTaxAmount = totalAssets * incomeTaxRate / 100;
        return incomeTaxAmount;
    }

    @Override
    public String toString() {
        return  "IncomeTax [incomeTaxRate=" + incomeTaxRate + ", maxIncomeTaxAmount=" + maxIncomeTaxAmount + "]";
    }

}