import java.util.HashMap;

public class TitleDeed extends Squares implements Comparable<TitleDeed> {
    // String: name of the square, <Interger: ,Integer: total number of same square>
    private static HashMap<String, Integer> tableSquare = new HashMap<String, Integer>();
    final static int PRICEMULTIPLAYER[] = { 1, 5, 15, 45, 80 };
    private Player owner;
    private int hoteles = 0;
    private int houses = 0;
    private int propertyPrice;
    private int rentPrice;
    private int hotelRentPrice = 0;

    TitleDeed(int position, String name,int propertyPrice, int rentPrice, int hotelRentPrice, String pseudo) {
        super(position, name, pseudo);
        this.rentPrice = rentPrice;
        this.propertyPrice = propertyPrice;
        this.hotelRentPrice = hotelRentPrice;
        if (tableSquare.containsKey(name))
            tableSquare.put(name, tableSquare.get(name) + 1);
        tableSquare.put(name, 1);
    }

    public boolean hasHotel() {
        return hoteles == 0 ? false : true;
    }

    public boolean hasHouse() {
        return houses == 0 ? false : true;
    }

    public int getHotel() {
        return this.hoteles;
    }

    public int compareTo(TitleDeed other) {
        return Integer.compare( other.propertyPrice,this.propertyPrice);
    }


    public int getRentPrice() {
        return rentPrice;
    }

    public int getHoteles() {
        return hoteles;
    }

    public int getHotelRentPrice() {
        return hotelRentPrice;
    }

    public Player getOwner() {
        return owner;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public int getHouse() {
        return this.houses;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    

    public void task(Player player) {
        if (this.owner == null) {
            // can buy
            if (player.getMoney() > this.propertyPrice) {

                char answer = 'R';
                do {
                    answer = API.Question("Do you want to buy this property? (Y/N)");
                } while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n');

                if (answer == 'Y' || answer == 'y') {
                    this.owner = player;
                    player.addProperty(this);
                    player.descreaseMoney(this.propertyPrice);
                }
            }

        } else if (owner.compareTo(player) == 0) {
            // You should pay
            int pay = rentPrice * PRICEMULTIPLAYER[houses];
            if (player.getMoney() > pay) {
                this.owner.increaseMoney(pay);
                player.descreaseMoney(pay);
                API.printMessageLn("You paid " + pay + " to " + this.owner.getName() + " for rent.");
            } else {
                this.owner.increaseMoney(player.getMoney());
                player.bankRuptcy();
            }
        } else {
            // owner can buy more houses

            API.printMessageLn("You are the owner of this property.");
            API.printMessage(String.valueOf(player.countPropertiesByPseudo(this.getPseudo())));

            API.printMessage(String.valueOf(Board.getValueByKey(this.getPseudo())));

            if (player.countPropertiesByPseudo(this.getPseudo()) == Board.getValueByKey(this.getPseudo())) {

                if (this.hoteles == 0) {
                    if (this.houses < 4) {
                        if (player.getMoney() > 50) {
                            char answer = 'R';
                            do {
                                answer = API.Question("Do you want to buy a house? (Y/N)   ");
                            } while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n');
                            if (answer == 'Y' || answer == 'y') {
                                this.houses += 1;
                                this.owner.descreaseMoney(50);
                            }
                        }
                    } else if (this.hoteles == 0) {
                        // owner can buy a Hotel
                        if (player.getMoney() > 600) {
                            char answer = 'R';
                            do {
                                answer = API.Question("Do you want to buy a Hotel? (Y/N)   ");
                            } while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n');

                            if (answer == 'Y' || answer == 'y') {
                                this.houses = 0;
                                this.hoteles = 1;
                                this.owner.descreaseMoney(600);
                            }

                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return " TitleDeed [ name = " + name + ",hoteles=" + hoteles + ", houses=" + houses + ", owner=" + owner
                + ", rentPrice=" + rentPrice
                + "]";
    }
}
