/**
 * GoToJail
 */
public class GoToJail extends Squares{

    GoToJail(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        player.goToJail();
    }

    
}