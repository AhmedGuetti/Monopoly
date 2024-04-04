
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class API {

    public static Scanner scanner = new Scanner(System.in);

    public static void payRentOrBuyRailRoad(Player player, RailRoad railRoad) {
        char answer = 'R';
        do {
            answer = API.Question("Do you want to buy this railroad? (y/n) ");
            System.out.print(":: => ");
        } while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n');

        if (answer == 'Y' || answer == 'y') {
            if (railRoad.buyRailRoad(player)) {
                System.out.println("You bought the railroad.");
            } else {
                System.out.println("You don't have enough money to buy this railroad.");
            }
            ;
        } else {
            railRoad.payRent(player);
        }
    }

    public static int printBoard(Player player) {

        System.out.println("================= Game Menu =================");
        System.out.println("                  " + player.getName() + "                  ");
        System.out.println("(1) Show the board");
        System.out.println("(2) Show money");
        System.out.println("(3) Roll Dice and move");
        System.out.println("(4) show status of all players ");
        System.out.print(":: => ");
        int res = scanner.nextInt();
        System.out.println("---------------------------------------------");

        return res;
    }

    public static char Question(String question) {
        System.out.println(question);
        System.out.print(":: => ");
        return scanner.next().charAt(0);
    }

    public static int QuestionNumvber(String question) {
        System.out.println(question);
        System.out.print(":: => ");
        return scanner.nextInt();
    }

    public static String QuestionString(String question) {
        System.out.println(question);
        System.out.print(":: => ");
        return scanner.next();
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printMessageLn(String message) {
        System.out.println(message);
    }

    public static void startGame() {

        int playerNumber = 0;

        do {

            playerNumber = API.QuestionNumvber("Enter the number of players : ");

        } while (playerNumber <= 0 || playerNumber > 6);

        Board board = new Board();

        Random rand = new Random();

        ArrayList<Player> players = new ArrayList<Player>(playerNumber);

        // iterate over set
        for (int i = 0; i < playerNumber; i++) {
            String name = API.QuestionString("Enter A name for player " + (i + 1) + " :");
            players.add(new Player(name + "__" + (i + 1), null, 0, 0));
        }

        Set<Integer> uniquePositions = new HashSet<>();

        // Simulate rolling the dice for each player
        List<Integer> playerPositions = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int diceRoll1 = rand.nextInt(6) + 1;
            int diceRoll2 = rand.nextInt(6) + 1;
            int totalDiceRoll = diceRoll1 + diceRoll2;

            while (uniquePositions.contains(totalDiceRoll)) {
                diceRoll1 = rand.nextInt(6) + 1;
                diceRoll2 = rand.nextInt(6) + 1;
                totalDiceRoll = diceRoll1 + diceRoll2;
            }

            uniquePositions.add(totalDiceRoll);
            playerPositions.add(totalDiceRoll);
        }

        // iterate over set
        for (int i = 0; i < playerNumber; i++) {
            players.get(i).setIndex(playerPositions.get(i));
        }

        Collections.sort(players);

        for (int i = 0; i < playerNumber; i++) {
            players.get(i).setToken(Tokens.fromNumber(i + 1));
        }

        int res = -1;
        for (; players.size() > 1;) {
            for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {

                Player currentPlayer = iterator.next();

                while (res != 3) {
                    res = API.printBoard(currentPlayer);
                    switch (res) {
                        case 1:
                            board.PrintBoard(players);
                            break;
                        case 2:
                            API.printMessageLn(String.valueOf(currentPlayer.getMoney()));
                            break;
                        case 3:
                            int dice1 = Dice.rollDice();
                            int dice2 = Dice.rollDice();
                            int step = dice1 + dice2;

                            int double_jail = 0;

                            do {
                                API.printMessageLn("Dice 1 : " + dice1 + " Dice 2 : " + dice2);

                                if (dice1 == dice2) {
                                    double_jail++;
                                    if (double_jail == 3) {
                                        currentPlayer.setPosition(10);
                                        currentPlayer.setInJailCount(2);
                                        API.printMessage("You are in jail for 2 turns");
                                        break;
                                    }
                                }

                                if (dice1 == dice2 && currentPlayer.getInJailCount() > 0) {
                                    currentPlayer.setInJailCount(0);
                                }
                                if (currentPlayer.getInJailCount() == 0) {

                                    currentPlayer.Advance(step);

                                    API.printMessageLn(
                                            "{ Current position : " + String.valueOf(currentPlayer.getPosition())
                                                    + " , Current player : "
                                                    + currentPlayer + " }");
                                    API.printMessageLn(
                                            "You landed on the square  : =>  { "
                                                    + board.getSquare(currentPlayer.getPosition()).toString() + " }");

                                    board.getSquare(currentPlayer.getPosition()).task(currentPlayer);
                                } else {
                                    API.printMessageLn(
                                            "You are in jail for " + currentPlayer.getInJailCount() + " turns");
                                    currentPlayer.decreaseInJailCount();
                                }

                            } while (dice1 == dice2);

                            break;
                        case 4:
                            for (Player player : players)
                                API.printMessageLn(player.toString());
                            break;
                        default:
                            API.printMessageLn("Enter a correct number ");
                            break;
                    }
                }
                res = -1;
                if (currentPlayer.getMoney() <= 0) {
                    API.printMessageLn("player: " + currentPlayer.getName() + " Lost this round !!");
                    iterator.remove();
                }
            }
        }
        API.printMessageLn("Player : " + players.get(0).getName() + " WIN this round");
    }

}
