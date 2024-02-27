
public class IncomeTax extends Squares{
    IncomeTax(int position, String name, String pseudo) {
        super(position, name, pseudo);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void task(Player player) {
       player.descreaseMoney(60);
    }
    
}