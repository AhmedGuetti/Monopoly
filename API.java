import java.util.Scanner;

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

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printMessageLn(String message) {
        System.out.println(message);
    }

}
