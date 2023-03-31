package Player;

public abstract class Player {
    private boolean whiteSide;
    private String name;

    public Player(String name ,boolean isWhiteSide){
        this.name=name;
        this.whiteSide=isWhiteSide;
    }
    public boolean isWhiteSide()
    {
        return this.whiteSide;
    }
    public String getName(){
        return this.name;
    }

}