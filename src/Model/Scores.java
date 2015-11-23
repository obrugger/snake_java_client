package Model;

import java.util.Date;

/**
 * Created by Oscar on 19-11-2015.
 */
public class Scores {

    private int id;
    private int user_id;
    private int game_id;
    private int score;
    private int opponent_id;

    public Scores(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getOpponent_id() {
        return opponent_id;
    }

    public void setOpponent_id(int opponent_id) {
        this.opponent_id = opponent_id;
    }
}
