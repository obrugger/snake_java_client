package Model;

import java.util.Date;

/**
 * Created by Oscar on 19-11-2015.
 */
public class Game {

    private long gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private String status;
    //private Date created;
    private int mapSize;

    public Game(){}

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public Gamer getHost() {
        return host;
    }

    public void setHost(Gamer host) {
        this.host = host;
    }

    public Gamer getOpponent() {
        return opponent;
    }

    public void setOpponent(Gamer opponent) {
        this.opponent = opponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }*/

    public Gamer getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }
}
