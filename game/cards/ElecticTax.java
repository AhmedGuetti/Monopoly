import java.util.ArrayList;

/**
 * ElecticTax
 */
public class ElecticTax extends Squares {

    final int ELECTRIC_TAX_HOTELS = 50;
    final int ELECTRIC_TAX_HOUSES = 25;
    final int ELECTRIC_TAX_RAILROADS = 100;

    ElecticTax(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {

        int amountToPay = calculateElectricTax(player);
        if (player.getMoney() > amountToPay) {
            player.descreaseMoney(calculateElectricTax(player));
        } else {
            player.descreaseMoney(player.getMoney());
            player.bankRuptcy();
        }
    }

    private int calculateElectricTax(Player player) {

        ArrayList<Squares> squares = player.getProperties();

        int amountToPay = 0;

        for (Squares square : squares) {
            if (square instanceof TitleDeed) {
                TitleDeed property = (TitleDeed) square;
                amountToPay += ELECTRIC_TAX_HOUSES * property.getHouse();
                amountToPay += ELECTRIC_TAX_HOTELS * property.getHotel();

            } else if (square instanceof RailRoad) {
                amountToPay += ELECTRIC_TAX_RAILROADS;
            }
        }

        return amountToPay;
    }

    @Override
    public String toString() {
        return  "ElecticTax [ELECTRIC_TAX_HOTELS=" + ELECTRIC_TAX_HOTELS + ", ELECTRIC_TAX_HOUSES="
                + ELECTRIC_TAX_HOUSES + ", ELECTRIC_TAX_RAILROADS=" + ELECTRIC_TAX_RAILROADS + "]";
    }

}