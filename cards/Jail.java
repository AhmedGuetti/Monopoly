/**
 * Jail
 */
public class Jail extends Squares {

    Jail(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        player.setPosition(10);
        player.setInJailCount(2);
    }

    @Override
    public String toString() {
        return "Jail [position=" + position + ", name=" + name + ", pseudo=" + pseudo + "]";
    }
}