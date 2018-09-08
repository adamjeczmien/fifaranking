package fifaranking;

/**
 *
 * @author jeczm
 */
public interface DataManagmentSystem {
    
    public void addPlayer(String name);
    
    public void modifyPlayerScore(Player p, int score);
    
    public void modifyPlayerName(Player p, String newName);
    
    public void getAllPlayers();
    
    public void removePlayer();

}
