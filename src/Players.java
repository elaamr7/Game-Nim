import java.util.ArrayList;
import java.util.List;

public class Players {
    private static List<String> players = new ArrayList<>();

    public Players(List<String> players){
        this.players = players;
    }

    public void change(){
        String temp = players.get(0);
        players.set(0,players.get(1));
        players.set(1,temp);
    }
    public void reset(){
        players.set(0,"Computer");
        players.set(1,"User");
    }
    public List<String> getPlayers(){

        return players;
    }
}
