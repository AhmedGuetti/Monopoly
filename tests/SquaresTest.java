import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SquaresTest {

    @Test
    public void testSquaresConstructor() {
        int position = 1;
        String name = "SquareName";
        String pseudo = "PN";

        Squares squares = new SquaresMock(position, name, pseudo);

        assertNotNull(squares);
        assertEquals(position, squares.getPosition());
        assertEquals(name, squares.getName());
        assertEquals(pseudo, squares.getPseudo());
    }

    private static class SquaresMock extends Squares {
        SquaresMock(int position, String name, String pseudo) {
            super(position, name, pseudo);
        }

        @Override
        public void task(Player player) {

        }
    }
}