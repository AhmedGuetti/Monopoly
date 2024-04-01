/**
 * WaterTax
 */
public class WaterTax extends Squares {

    private final int baseTaxAmount = 75;
    private final int propertyTaxAmount = 25;
    private final int railroadTaxAmount = 50;

    WaterTax(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        int taxAmount = baseTaxAmount;

        int ownedProperties = player.getProperties().size();
        int ownedRailroads = player.getRailRoadsCount();

        taxAmount += ownedProperties * propertyTaxAmount;
        taxAmount += ownedRailroads * railroadTaxAmount;

        if (player.getMoney() < taxAmount) {
            player.bankRuptcy();
        } else {
            player.descreaseMoney(taxAmount);
        }
    }

    @Override
    public String toString() {
        return  "WaterTax [baseTaxAmount=" + baseTaxAmount + ", propertyTaxAmount="
                + propertyTaxAmount + ", railroadTaxAmount=" + railroadTaxAmount + "]";
    }
}