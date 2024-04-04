import static org.junit.Assert.*;
import org.junit.Test;


public class BoardTest {

    @Test
    public void testGetCountByPseudo() {

        Board board = new Board();
        int count = board.getCountByPseudo("JN");
        assertEquals(2, count);

        int count2 = board.getCountByPseudo("MA");
        assertEquals(3, count2);

        int count3 = board.getCountByPseudo("VA");
        assertEquals(3, count3);

        int count4 = board.getCountByPseudo("BW");
        assertEquals(2, count4);

        int count5 = board.getCountByPseudo("NY");
        assertEquals(3, count5);

        int count6 = board.getCountByPseudo("PA");
        assertEquals(3, count6);

        int count7 = board.getCountByPseudo("IA");
        assertEquals(4, count7);

        int count8 = board.getCountByPseudo("MG");
        assertEquals(2, count8);
    }



    @Test
    public void testGetSquare() {
        Board board = new Board();
        Squares square = board.getSquare(0);
        assertNotNull(square);
        assertEquals("GO", square.getName());
    }

}