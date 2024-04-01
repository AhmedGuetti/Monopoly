import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Board {
    private ArrayList<Squares> board;

    private static HashMap<String, Integer> pseudoCounts = new HashMap<String, Integer>() {
        {
            put("JN", 2);
            put("MA", 3);
            put("VA", 3);
            put("BW", 2);
            put("NY", 3);
            put("PA", 3);
            put("IA", 4);
            put("MG", 2);

        }
    };

    public static int getValueByKey(String key) {
        return pseudoCounts.get(key);
    }

    Board() {
        // First row

        board = new ArrayList<Squares>(40);
        board.add(new Go(0, "GO", "GO"));
        board.add(new TitleDeed(1, "JEAN NICOLI AVE", 14, 0, "JN"));
        board.add(new CommunityChest(2, "Community Chest", "CC"));
        board.add(new TitleDeed(3, "JEAN NICOLI AVE", 14, 0, "JN"));
        board.add(new IncomeTax(4, "Income Tax", "IT"));
        board.add(new RailRoad(5, "Rail Road", "RR"));
        board.add(new TitleDeed(6, "MEDITERRANEAN AVE", 2, 0, "MA"));
        board.add(new Chance(7, "Chance", "CH"));
        board.add(new TitleDeed(8, "MEDITERRANEAN AVE", 2, 0, "MA"));
        board.add(new TitleDeed(9, "MEDITERRANEAN AVE", 2, 0, "MA"));
        board.add(new Jail(10, "Jail", "JL"));

        // one left one right
        board.add(new TitleDeed(11, "VIRGINIA AVE", 12, 0, "VA"));
        board.add(new TitleDeed(39, "BOARDWALK", 50, 0, "BW"));

        board.add(new ElecticTax(12, "Electric Tax", "ET"));
        board.add(new LuxuryTax(38, "Luxury Tax", "LX"));

        board.add(new TitleDeed(13, "VIRGINIA AVE", 12, 0, "VA"));
        board.add(new TitleDeed(37, "BOARDWALK", 50, 0, "BW"));

        board.add(new TitleDeed(14, "VIRGINIA AVE", 12, 0, "VA"));
        board.add(new Chance(36, "Chance", "CH"));

        board.add(new RailRoad(15, "Rail Road", "RR"));
        board.add(new RailRoad(35, "Rail Road", "RR"));

        board.add(new TitleDeed(16, "NEW YORK AVE", 16, 0, "NY"));
        board.add(new TitleDeed(34, "PACIFIC AVE", 26, 0, "PA"));

        board.add(new CommunityChest(17, "Community Chest", "CC"));
        board.add(new CommunityChest(33, "Community Chest", "CC"));

        board.add(new TitleDeed(18, "NEW YORK AVE", 16, 0, "NY"));
        board.add(new TitleDeed(32, "PACIFIC AVE", 26, 0, "PA"));

        board.add(new TitleDeed(19, "NEW YORK AVE", 16, 0, "NY"));
        board.add(new TitleDeed(31, "PACIFIC AVE", 26, 0, "PA"));

        // Top
        board.add(new FreeParking(20, "Free Parking", "PR"));
        board.add(new TitleDeed(21, "ILLINIOS AVE", 20, 0, "IA"));
        board.add(new Chance(22, "Chance", "CH"));
        board.add(new TitleDeed(23, "ILLINIOS AVE", 20, 0, "IA"));
        board.add(new TitleDeed(24, "ILLINIOS AVE", 20, 0, "IA"));
        board.add(new RailRoad(25, "Rail Road", "RR"));
        board.add(new TitleDeed(26, "MARVIN GARENS", 24, 0, "MG"));
        board.add(new TitleDeed(27, "ILLINIOS AVE", 24, 0, "MG"));
        board.add(new WaterTax(28, "Water Tax", "WT"));
        board.add(new TitleDeed(29, "ILLINIOS AVE", 24, 0, "IA"));
        board.add(new GoToJail(30, "Go To Jail", "GJ"));
    }

    public int getCountByPseudo(String pseudo) {
        int count = 0;
        for (Squares square : this.board) {
            if (square.getPseudo().equals(pseudo))
                count++;
        }
        return count;
    }

    public Squares getSquare(int position) {

        for (Squares square : this.board) {
            if (square.getPosition() == position)
                return square;
        }

        // return this.board.get(position);
        return null;
    }

    public void PrintBoard(ArrayList<Player> players) {
        int i;
        boolean PlayerExist = false;
        for (i = 0; i <= 10; i++) {
            for (Player player : players) {
                if (player.getPosition() == this.board.get(i).getPosition()) {
                    this.board.get(i).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if (!PlayerExist)
                this.board.get(i).print(null);
            PlayerExist = false;
        }
        API.printMessage("\n");
        PlayerExist = false;
        for (i = 11; i <= 28; i += 2) {
            for (Player player : players) {
                if (player.getPosition() == this.board.get(i + 1).getPosition()) {
                    this.board.get(i + 1).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if (!PlayerExist)
                this.board.get(i + 1).print(null);
            PlayerExist = false;
            for (int j = 0; j < 9; j++)
                API.printMessage("\t");

            for (Player player : players) {
                if (player.getPosition() == this.board.get(i).getPosition()) {
                    this.board.get(i).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if (!PlayerExist)
                this.board.get(i).print(null);

            PlayerExist = false;
            API.printMessage("\n");
        }
        PlayerExist = false;
        for (i = 29; i <= 39; i++) {
            for (Player player : players) {
                if (player.getPosition() == this.board.get(i).getPosition()) {
                    this.board.get(i).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if (!PlayerExist)
                this.board.get(i).print(null);
            PlayerExist = false;
        }
        API.printMessage("\n");
    }

    public static void startGame() {
        int playerNumber = 3;
        Player p1 = new Player("Ahmed", Tokens.Hat, 0);
        Player p2 = new Player("Ilyas", Tokens.Cannon, 0);
        Player p3 = new Player("Amine", Tokens.Car, 0);

        ArrayList<Player> players = new ArrayList<Player>(playerNumber);
        players.add(p1);
        players.add(p2);
        players.add(p3);

        Board board = new Board();
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

                            API.printMessageLn("Dice 1 : " + dice1 + " Dice 2 : " + dice2);

                            if (dice1 == dice2) {
                                currentPlayer.setInJailCount(0);
                            }
                            if (currentPlayer.getInJailCount() == 0) {

                                currentPlayer.Advance(step);

                                API.printMessageLn("{ Current position : " + String.valueOf(currentPlayer.getPosition())
                                        + " , Current player : "
                                        + currentPlayer + " }");
                                API.printMessageLn(
                                        "You landed on the square  : =>  { "
                                                + board.getSquare(currentPlayer.getPosition()).toString() + " }");

                                board.getSquare(currentPlayer.getPosition()).task(currentPlayer);
                            } else {

                                API.printMessageLn("You are in jail for " + currentPlayer.getInJailCount() + " turns");
                                currentPlayer.decreaseInJailCount();

                            }
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