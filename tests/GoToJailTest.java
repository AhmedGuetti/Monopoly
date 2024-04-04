import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GoToJailTest {

    @Test
    public void testTask() {
        int position = 20;
        String name = "Go To Jail";
        String pseudo = "GJ";
        Player player = new Player("Ahmed", Tokens.Cannon, position, 0);

        GoToJail goToJail = new GoToJail(position, name, pseudo);

        goToJail.task(player);

        assertEquals(10, player.getPosition());
        assertEquals(2, player.getInJailCount());
    }

    @Test
    public void testToString() {
        int position = 20;
        String name = "Go To Jail";
        String pseudo = "GJ";
        GoToJail goToJail = new GoToJail(position, name, pseudo);

        String result = goToJail.toString();

        assertEquals("GoToJail [position=" + position + ", name=" + name + ", pseudo=" + pseudo + "]", result);
    }
}