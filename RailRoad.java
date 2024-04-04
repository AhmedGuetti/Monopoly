public class RailRoad extends Squares implements Comparable<RailRoad> {

    private Player owner;
    private final int price = 200;
    private final int rent = 25;
    private final int rent1 = 50;
    private final int rent2 = 100;
    private final int rent3 = 200;

    RailRoad(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {

        API.payRentOrBuyRailRoad(player, this);
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    public int getPrice() {
        return price;
    }


    public Player getOwner() {
        return owner;
    }

    public boolean buyRailRoad(Player player) {
        if (player.getMoney() > price) {
            player.descreaseMoney(price);
            this.setOwner(player);
            player.addRailRoad(this);
            player.increaseRailRoadsCount();
            return true;
        } else {
            return false;
        }
    }

    public void payRent(Player player) {
        int rentAmount = 0;

        if (owner != null) {
            switch (owner.getRailRoadsCount()) {
                case 1:
                    rentAmount = rent;
                    break;
                case 2:
                    rentAmount = rent1;
                    break;
                case 3:
                    rentAmount = rent2;
                    break;
                case 4:
                    rentAmount = rent3;
                    break;
                default:
                    break;
            }
            if (player.getMoney() > rentAmount) {
                player.descreaseMoney(rentAmount);
                owner.increaseMoney(rentAmount);
            } else {
                owner.increaseMoney(player.getMoney());
                player.bankRuptcy();
            }
        }

    }

    @Override
    public String toString() {
        return "RailRoad{ name =" + name + ",owner=" + owner + ", price=" + price + ", rent=" + rent + ", rent1="
                + rent1 + ", rent2=" + rent2 + ", rent3=" + rent3 + '}';
    }

    @Override
    public int compareTo(RailRoad o) {
        return Integer.compare(o.price, this.price);
    }
}
