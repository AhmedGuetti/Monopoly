import java.util.ArrayList;
import java.util.UUID;



class Player implements Comparable{
    final static int START_MONEY = 1500;
    private String name;
    private int position;
    UUID uuid = UUID.randomUUID();
    private String uuidString;
    private int money;
    private boolean lose = false;
    private Tokens token;
    private ArrayList<Squares> properties;

    public Player(String name, Tokens token, int position){
        this.name = name;
        this.money = START_MONEY;
        this.token = token;
        this.position = position;
        this.uuidString = uuid.toString();
    }


    // getter
    public int getMoney() {return money;}
    public String getUuidString() {return uuidString;}
    public String getName() {return name;}
    public String getToken() {return Tokens.toStringo(token);}
    public int getPosition() {return position;}
    public ArrayList<Squares> getProperties() {return properties;}

    //setter
    public void setName(String name) {this.name = name;}
    public void setPosition(int position) {this.position = position;}
    public void bankRuptcy(){
        this.money = 0;
        this.lose = true;
    }

    public void descreaseMoney(int amount){
        this.money -= amount;
        if(money<=0){
            money = 0;
            lose = true;
        }
    }

    public void addProperty(Squares square){
        this.properties.add(square);
    }
    
    public int numberProperties(String name){
        int res = 0;
        for (Squares square : properties)
            if (square.getName().equals(name))
                ++res;
        return res;
    }
    public void increaseMoney(int amount){this.money += amount;}



    public void Advance(int step){
        this.position += step;
        if(this.position>=40)
            this.position -= 40;
    }

    public void goToJail(){this.position = 10;}

    @Override
    public int compareTo(Object o) {
        Player  p = (Player) o;
        if(p.getUuidString().equals(this.getUuidString()))
            return 1;
        return 0;
    }
    @Override
    public String toString() {
        return this.name+": "+this.money+" M";
    }
}