
public class FreeParking extends Squares {

    FreeParking(int position, String name, String pseudo) {
        super(position, name, pseudo);
    }

    @Override
    public void task(Player player) {
        // Do nothing
    }

    @Override
    public String toString() {
        return "FreeParking [position=" + position + ", name=" + name + ", pseudo=" + pseudo + "]";
    }
}