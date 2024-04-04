/**
 * GoToJail
 */
public class GoToJail extends Squares{

    GoToJail(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        player.setPosition(10);
        player.setInJailCount(2);
    }

    @Override
    public String toString() {
        return "GoToJail [position=" + position + ", name=" + name + ", pseudo=" + pseudo + "]";
    }
}