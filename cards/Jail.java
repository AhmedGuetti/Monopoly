/**
 * Jail
 */
public class Jail extends Squares {

    Jail(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        // jsut visiting
    }

    @Override
    public String toString() {
        return "Jail [position=" + position + ", name=" + name + ", pseudo=" + pseudo + "]";
    }
}