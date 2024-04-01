public class Go extends Squares{

    Go(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }
    
    public void task(Player player){
        player.increaseMoney(200);
    }

    @Override
    public String toString() {
        return "Go [position=" + position + ", name=" + name + ", pseudo=" + pseudo + "]";
    }
}