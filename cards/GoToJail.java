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

    @Override
    public String toString() {
        return "GoToJail [position=" + position + ", name=" + name + ", pseudo=" + pseudo + "]";
    }
}