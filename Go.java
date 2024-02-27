public class Go extends Squares{

    Go(int position, String name, String pseudo) {
        super(position, name, pseudo);
        //TODO Auto-generated constructor stub
    }
    
    public void task(Player player){
        player.increaseMoney(200);
    }

}