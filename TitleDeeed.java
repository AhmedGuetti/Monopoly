import java.util.HashMap;

public class TitleDeeed extends Squares{
    //String: name of the square, <Interger: ,Integer: total number of same square>
    private static HashMap<String, Integer> tableSquare = new HashMap<String, Integer>();
    final static int PRICEMULTIPLAYER[] = {1, 5, 15, 45, 80};
    private Player owner;
    private int hoteles = 0;
    private int houses = 0;
    private int rentPrice;

    TitleDeeed(int position, String name, int rentPrice, String pseudo){
        super(position, name, pseudo);
        this.rentPrice = rentPrice;
        if(tableSquare.containsKey(name))
            tableSquare.put(name, tableSquare.get(name) + 1);
        tableSquare.put(name, 1);
    }

    public boolean hasHotel(){return hoteles==0?false:true;}
    public boolean hasHouse(){return houses==0?false:true;}

    public int getHotel(){return this.hoteles;}
    public int getHouse(){return this.houses;}
    

    public void task(Player player){
        if(this.owner == null){ 
            // can buy
            this.owner = player;
            player.descreaseMoney(this.rentPrice);
            // player.addProperty(this);
        }
        else if(owner.compareTo(player) == 0){
            // You should pay
            int pay = rentPrice*PRICEMULTIPLAYER[houses];
            if(player.getMoney() > pay){
                this.owner.increaseMoney(pay);
                player.descreaseMoney(pay);
            } else{
                this.owner.increaseMoney(player.getMoney());
                player.bankRuptcy();
            }
        } else{
            // owner can buy more houses 
            if(this.houses < 4){
                this.houses += 1;
                this.owner.descreaseMoney(50);
            }else if(this.hoteles == 0){
                // owner can buy a Hotel
                this.houses = 0;
                this.hoteles = 1;
                this.owner.descreaseMoney(600);
            }
        }
    }
    

}   
