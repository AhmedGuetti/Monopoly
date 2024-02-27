import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Board {
    private ArrayList<Squares> board;
    Board(){
        // First row
        board = new ArrayList<Squares>(40);
        board.add(new Go(0, "GO", "GO"));
        board.add(new TitleDeeed(1, "JEAN NICOLI AVE", 14,"JN"));
        board.add(new CommunityChest(2, "Community Chest","CC"));
        board.add(new TitleDeeed(3, "JEAN NICOLI AVE", 14,"JN"));
        board.add(new IncomeTax(4, "Income Tax","IT"));
        board.add(new RailRoad(5, "Rail Road","RR"));
        board.add(new TitleDeeed(6, "MEDITERRANEAN AVE", 2,"MA"));
        board.add(new Chance(7, "Chance","CH"));
        board.add(new TitleDeeed(8, "MEDITERRANEAN AVE", 2,"MA"));
        board.add(new TitleDeeed(9, "MEDITERRANEAN AVE", 2,"MA"));
        board.add(new Jail(10, "Jail","JL"));

        // one left one right 
        board.add(new TitleDeeed(11, "VIRGINIA AVE",12,"VA"));
        board.add(new TitleDeeed(39, "BOARDWALK",50,"BW"));

        board.add(new ElecticTax(12, "Electric Tax","ET"));
        board.add(new LuxuryTax(38, "Luxury Tax","LX"));

        board.add(new TitleDeeed(13, "VIRGINIA AVE",12,"VA"));
        board.add(new TitleDeeed(37, "BOARDWALK",50,"BW"));

        board.add(new TitleDeeed(14, "VIRGINIA AVE",12,"VA"));
        board.add(new Chance(36, "Chance","CH"));

        board.add(new RailRoad(15, "Rail Road","RR"));
        board.add(new RailRoad(35, "Rail Road","RR"));
        
        board.add(new TitleDeeed(16, "NEW YORK AVE",16,"NY"));
        board.add(new TitleDeeed(34, "PACIFIC AVE",26,"PA"));

        board.add(new CommunityChest(17, "Community Chest","CC"));
        board.add(new CommunityChest(33, "Community Chest","CC"));

        board.add(new TitleDeeed(18, "NEW YORK AVE",16,"NY"));
        board.add(new TitleDeeed(32, "PACIFIC AVE",26,"PA"));

        board.add(new TitleDeeed(19, "NEW YORK AVE",16,"NY"));
        board.add(new TitleDeeed(31, "PACIFIC AVE",26,"PA"));

        // Top 
        board.add(new FreeParking(20, "Free Parking","PR"));
        board.add(new TitleDeeed(21, "ILLINIOS AVE", 20,"IA"));
        board.add(new Chance(22, "Chance","CH"));
        board.add(new TitleDeeed(23, "ILLINIOS AVE", 20,"IA"));
        board.add(new TitleDeeed(24, "ILLINIOS AVE", 20,"IA"));
        board.add(new RailRoad(25, "Rail Road","RR"));
        board.add(new TitleDeeed(26, "MARVIN GARENS", 24,"MG"));
        board.add(new TitleDeeed(27, "ILLINIOS AVE", 24,"MG"));
        board.add(new WaterTax(28, "Water Tax","WT"));
        board.add(new TitleDeeed(29, "ILLINIOS AVE", 24,"IA"));
        board.add(new GoToJail(30, "Go To Jail","GJ"));
    }
    public Squares getSquare(int position){
        return this.board.get(position);
    }
    public void PrintBoard(ArrayList<Player> players){
        int i;
        boolean PlayerExist = false;
        for (i = 0; i<=10; i++){
            for (Player player : players){
                if(player.getPosition() == this.board.get(i).getPosition()){
                    this.board.get(i).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if(!PlayerExist) this.board.get(i).print(null);
            PlayerExist = false;    
        }
        System.out.print("\n");
        PlayerExist = false;
        for (i = 11; i<=28; i+=2){
            for (Player player : players){
                if(player.getPosition() == this.board.get(i+1).getPosition()){
                    this.board.get(i+1).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if(!PlayerExist)  this.board.get(i+1).print(null);
            PlayerExist = false;
            for (int j = 0; j < 9; j++)
                System.out.print("\t");

            for (Player player : players) {
                if(player.getPosition() == this.board.get(i).getPosition()){
                    this.board.get(i).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if(!PlayerExist) this.board.get(i).print(null);

            PlayerExist = false;
            System.out.print("\n");
        }
        PlayerExist = false;
        for (i = 29; i <= 39; i++){
            for (Player player : players){
                if(player.getPosition() == this.board.get(i).getPosition()){
                    this.board.get(i).print(player);
                    PlayerExist = true;
                    break;
                }
            }
            if(!PlayerExist) this.board.get(i).print(null);
            PlayerExist = false; 
        }
        System.out.print("\n");
    }


    public static void startGame(){
        int playerNumber = 2;
       Player p1 = new Player("Ahmed",Tokens.Hat,0);
       Player p2 = new Player("Ilyas",Tokens.Cannon,0);
       ArrayList<Player> players = new ArrayList<Player>(playerNumber);
       players.add(p1); players.add(p2);
       Board board = new Board();
       Scanner scan = new Scanner(System.in);
       int res = -1;
       for (;players.size()>1;) {
           for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
               Player currentPlayer = iterator.next();
               while (res != 3) {
                   System.out.println("================= Game Menu =================");
                   System.out.println("                  "+ currentPlayer.getName() +"                  ");
                   System.out.println("(1) Show the board");
                   System.out.println("(2) Show money");
                   System.out.println("(3) Roll Dice and move");
                   System.out.println("(4) show status of all players ");
                   res = scan.nextInt();
                   System.out.println("---------------------------------------------");
                   switch (res) {
                       case 1:
                           board.PrintBoard(players);
                           break;
                       case 2:
                           System.out.println(currentPlayer.getMoney());
                           break;
                       case 3:
                           int step = Dice.rollDice(2);
                           System.out.println(step);
                           System.out.println(currentPlayer.getPosition());
                           currentPlayer.Advance(step);
                           board.getSquare(currentPlayer.getPosition()).task(currentPlayer);
                           break;
                       case 4:
                            for (Player player : players)
                                System.out.println(player.toString());
                           break;
                       default:
                           System.out.println("Enter a correct number ");
                           break;
                   } 
               }
               res=-1;
               if(currentPlayer.getMoney()<=0){
                   System.out.println("player: "+currentPlayer.getName()+" Lost this round !!");
                   iterator.remove();
               }
           }
       }
       System.out.println("Player : "+players.get(0).getName()+" WIN this round" );
   }
}