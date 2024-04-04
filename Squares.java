


abstract class Squares {
    
    public int position;
    public String name;
    public String pseudo;


    Squares(int position, String name, String pseudo){
        this.position = position;
        this.name = name;
        this.pseudo = pseudo;
    }   

    public String getName() {return name;}
    public int getPosition() {return position;}
    public String getPseudo() {
        return pseudo;
    }
    
    public void print(Player player){
        if(player == null)
            System.out.print(pseudo+"\t");
        else
            System.out.print(player.getToken()+pseudo+"\033[;;1m\t");
    }

    public abstract void task(Player player);

}