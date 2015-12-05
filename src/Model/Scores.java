package Model;


/**
 * The Scores class.
 * Contains the variables, used for retreiving
 * the highscore.
 *
 * @author Oscar
 * @since 19-11-2015
 *
 * Created by Oscar on 19-11-2015.
 */
public class Scores {

    /** The user id. */
    private int userId;
    
    /** The score. */
    private int score;


    /**
     * Creates the Scores constructor.
     */
    public Scores(){

    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score the new score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
