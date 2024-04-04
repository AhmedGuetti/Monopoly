
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


class Player implements Comparable<Player> {

    final static int START_MONEY = 1500;
    private String name;
    private int position;
    UUID uuid = UUID.randomUUID();
    private String uuidString;
    private int money;
    private boolean lose = false;
    private Tokens token;
    private ArrayList<TitleDeed> properties;
    private ArrayList<RailRoad> railRoads;
    private int inJailCount = 0;
    private int index = 0;
    private int RailRoadsCount = 0;

    public Player(String name, Tokens token, int position, int index)  {
        this.name = name;
        this.money = START_MONEY;
        this.token = token;
        this.position = position;
        this.uuidString = uuid.toString();
        this.properties = new ArrayList<>();
        this.railRoads = new ArrayList<>();
        this.inJailCount = 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public void addRailRoad(RailRoad square) {
        this.railRoads.add(square);
    }

    public void setToken(Tokens token) {
        this.token = token;
    }

    public ArrayList<RailRoad> getRailRoads() {
        return railRoads;
    }

    public int getInJailCount() {
        return inJailCount;
    }

    public void setInJailCount(int inJailCount) {
        this.inJailCount = inJailCount;
    }

    public void decreaseInJailCount() {
        this.inJailCount--;
    }

    // getter
    public int getMoney() {
        return money;
    }

    public String getUuidString() {
        return uuidString;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return Tokens.toStringo(token);
    }

    public int getPosition() {
        return position;
    }

    public ArrayList<TitleDeed> getProperties() {
        return properties;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void bankRuptcy() {

        Collections.sort(properties);

        ArrayList<TitleDeed> toRemove = new ArrayList<>();

        if (this.money < 0) {
            if (this.properties.size() > 0) {
                for (TitleDeed square_title : properties) {
                    this.increaseMoney(square_title.getPropertyPrice());
                    square_title.setOwner(null);
                    toRemove.add(square_title);
                    if (this.money >= 0)
                        break;
                }
            }
        }

        for (TitleDeed square_title : toRemove) {
            this.properties.remove(square_title);
        }

        // same with railsroads
        Collections.sort(railRoads);

        ArrayList<RailRoad> toRemoveRail = new ArrayList<>();

        if (this.money < 0) {
            if (this.railRoads.size() > 0) {
                for (RailRoad square_title : railRoads) {
                    this.increaseMoney(square_title.getPrice());
                    square_title.setOwner(null);
                    toRemoveRail.add(square_title);
                    if (this.money >= 0)
                        break;
                }
            }
        }

        for (RailRoad square_title : toRemoveRail) {
            this.railRoads.remove(square_title);
        }

        // final check about the price

        if (this.money < 0) {
            this.money = 0;
            this.lose = true;
        }

    }

    public void increaseRailRoadsCount() {
        RailRoadsCount++;
    }

    public int getRailRoadsCount() {
        return RailRoadsCount;
    }

    public void descreaseMoney(int amount) {
        this.money -= amount;
        if (money <= 0) {
            money = 0;
            lose = true;
        }
    }

    public void addProperty(TitleDeed square) {
        this.properties.add(square);
    }

    public int numberProperties(String name) {
        int res = 0;
        for (Squares square : properties)
            if (square.getName().equals(name))
                ++res;
        return res;
    }

    public void increaseMoney(int amount) {
        this.money += amount;
    }

    public void Advance(int step) {
        this.position += step;
        if (this.position >= 40)
            this.position -= 40;
    }

    public void goToJail() {
        this.position = 10;
        this.inJailCount = 2;
    }

  
    public int countPropertiesByPseudo(String pseudo) {
        int res = 0;
        for (Squares square : properties)
            if (square.getPseudo().equals(pseudo))
                ++res;
        return res;
    }

    @Override
    public String toString() {
        return "Player [money=" + money + ", name=" + name + ", position=" + position + ", token=" + token + "]";
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getIndex(),this.getIndex() );
    }
}