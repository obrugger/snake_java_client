package Model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 19-11-2015.
 */
public class Game {

    /** The game id. */
    private long gameId;
    
    /** The winner. */
    private Gamer winner;
    
    /** The name. */
    private String name;
    
    /** The host. */
    private Gamer host;
    
    /** The opponent. */
    private Gamer opponent;
    
    /** The status. */
    private String status;
    //private Date created;
    /** The map size. */
    private int mapSize;

    /**
     * Instantiates a new game.
     */
    public Game(){}

    /**
     * Gets the game id.
     *
     * @return the game id
     */
    public long getGameId() {
        return gameId;
    }

    /**
     * Sets the game id.
     *
     * @param gameId the new game id
     */
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    /**
     * Gets the host.
     *
     * @return the host
     */
    public Gamer getHost() {
        return host;
    }

    /**
     * Sets the host.
     *
     * @param host the new host
     */
    public void setHost(Gamer host) {
        this.host = host;
    }

    /**
     * Gets the opponent.
     *
     * @return the opponent
     */
    public Gamer getOpponent() {
        return opponent;
    }

    /**
     * Sets the opponent.
     *
     * @param opponent the new opponent
     */
    public void setOpponent(Gamer opponent) {
        this.opponent = opponent;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /*public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }*/

    /**
     * Gets the winner.
     *
     * @return the winner
     */
    public Gamer getWinner() {
        return winner;
    }

    /**
     * Sets the winner.
     *
     * @param winner the new winner
     */
    public void setWinner(Gamer winner) {
        this.winner = winner;
    }

    /**
     * Gets the map size.
     *
     * @return the map size
     */
    public int getMapSize() {
        return mapSize;
    }

    /**
     * Sets the map size.
     *
     * @param mapSize the new map size
     */
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }
}
