import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void testAddProperty() {
        Player player = new Player("Alice", Tokens.Cannon, 0, 0);
        TitleDeed property = new TitleDeed(1, "Park Place", 350, 35, 175, "PK");

        player.addProperty(property);

        assertTrue(player.getProperties().contains(property));
    }

    @Test
    public void testIncreaseMoney() {
        Player player = new Player("Bob", Tokens.Car, 0, 0);
        int initialMoney = player.getMoney();
        int amount = 200;

        player.increaseMoney(amount);

        assertEquals(initialMoney + amount, player.getMoney());
    }

    @Test
    public void testDecreaseMoney() {
        Player player = new Player("Charlie", Tokens.Dog, 0, 0);
        player.setMoney(1000);
        int initialMoney = player.getMoney();
        int amount = 300;

        player.descreaseMoney(amount);

        assertEquals(initialMoney - amount, player.getMoney());
    }

    @Test
    public void testAdvance() {
        Player player = new Player("David", Tokens.Hat, 0, 0);
        int initialPosition = player.getPosition();
        int step = 5;

        player.Advance(step);

        assertEquals((initialPosition + step) % 40, player.getPosition());
    }

    @Test
    public void testGoToJail() {
        Player player = new Player("Eve", Tokens.Cannon, 0, 0);

        player.goToJail();

        assertEquals(2, player.getInJailCount());
    }

    @Test
    public void testIncreaseRailRoadsCount() {
        Player player = new Player("Frank", Tokens.Timble, 0, 0);
        int initialCount = player.getRailRoadsCount();

        player.increaseRailRoadsCount();

        assertEquals(initialCount + 1, player.getRailRoadsCount());
    }

    @Test
    public void testAddRailRoad() {
        Player player = new Player("George", Tokens.Cannon, 0, 0);
        RailRoad railRoad = new RailRoad(16,"Reading Railroad", "JR");

        player.addRailRoad(railRoad);

        assertTrue(player.getRailRoads().contains(railRoad));
    }

    @Test
    public void testSetMoney() {
        Player player = new Player("Helen", Tokens.Cannon, 0, 0);
        int newMoney = 1500;

        player.setMoney(newMoney);

        assertEquals(newMoney, player.getMoney());
    }

}