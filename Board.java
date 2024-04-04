
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;



class Board {

    private ArrayList<Squares> board;
    ArrayList<Player> players = new ArrayList<Player>();
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
        board.add(new TitleDeed(1, "JEAN NICOLI AVE", 150, 50, 100, "JN"));
        board.add(new CommunityChest(2, "Community Chest", "CC"));
        board.add(new TitleDeed(3, "JEAN NICOLI AVE", 200, 30, 50, "JN"));
        board.add(new IncomeTax(4, "Income Tax", "IT"));
        board.add(new RailRoad(5, "Rail Road", "RR"));
        board.add(new TitleDeed(6, "MEDITERRANEAN AVE", 250, 30, 90, "MA"));
        board.add(new Chance(7, "Chance", "CH"));
        board.add(new TitleDeed(8, "MEDITERRANEAN AVE", 300, 60, 60, "MA"));
        board.add(new TitleDeed(9, "MEDITERRANEAN AVE", 200, 60, 80, "MA"));
        board.add(new Jail(10, "Jail", "JL"));

        // one left one right
        board.add(new TitleDeed(11, "VIRGINIA AVE", 250, 28, 46, "VA"));
        board.add(new TitleDeed(39, "BOARDWALK", 750, 55, 60, "BW"));

        board.add(new ElecticTax(12, "Electric Tax", "ET"));
        board.add(new LuxuryTax(38, "Luxury Tax", "LX"));

        board.add(new TitleDeed(13, "VIRGINIA AVE", 350, 110, 60, "VA"));
        board.add(new TitleDeed(37, "BOARDWALK", 500, 102, 30, "BW"));

        board.add(new TitleDeed(14, "VIRGINIA AVE", 560, 30, 60, "VA"));
        board.add(new Chance(36, "Chance", "CH"));

        board.add(new RailRoad(15, "Rail Road", "RR"));
        board.add(new RailRoad(35, "Rail Road", "RR"));

        board.add(new TitleDeed(16, "NEW YORK AVE", 290, 45, 50, "NY"));
        board.add(new TitleDeed(34, "PACIFIC AVE", 380, 60, 60, "PA"));

        board.add(new CommunityChest(17, "Community Chest", "CC"));
        board.add(new CommunityChest(33, "Community Chest", "CC"));

        board.add(new TitleDeed(18, "NEW YORK AVE", 410, 60, 45, "NY"));
        board.add(new TitleDeed(32, "PACIFIC AVE", 400, 40, 60, "PA"));

        board.add(new TitleDeed(19, "NEW YORK AVE", 500, 90, 90, "NY"));
        board.add(new TitleDeed(31, "PACIFIC AVE", 350, 56, 56, "PA"));

        // Top
        board.add(new FreeParking(20, "Free Parking", "PR"));
        board.add(new TitleDeed(21, "ILLINIOS AVE", 410, 30, 30, "IA"));
        board.add(new Chance(22, "Chance", "CH"));
        board.add(new TitleDeed(23, "ILLINIOS AVE", 500, 40, 40, "IA"));
        board.add(new TitleDeed(24, "ILLINIOS AVE", 450, 40, 40, "IA"));
        board.add(new RailRoad(25, "Rail Road", "RR"));
        board.add(new TitleDeed(26, "MARVIN GARENS", 300, 66, 77, "MG"));
        board.add(new TitleDeed(27, "ILLINIOS AVE", 400, 100, 100, "MG"));
        board.add(new WaterTax(28, "Water Tax", "WT"));
        board.add(new TitleDeed(29, "ILLINIOS AVE", 330, 100, 200, "IA"));
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

  
}