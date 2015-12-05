package Model;

/**
 * The Gamer class - an extension of User.
 * Used for storing information after a
 * game played.
 *
 * @author Oscar
 * @since 26-11-2015
 *
 * Created by Oscar on 26-11-2015.
 */
public class Gamer extends User{


    /** The score. */
    private int score;
    
    /** The total score. */
    private int totalScore;
    
    /** The kills. */
    private int kills;
    
    /** The controls. */
    private String controls;
    
    /** The winner. */
    private boolean winner;

    /**
     * Creates the Gamer constructor.
     */
    public Gamer(){

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

    /**
     * Gets the total score.
     *
     * @return the total score
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Sets the total score.
     *
     * @param totalScore the new total score
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * Gets the kills.
     *
     * @return the kills
     */
    public int getKills() {
        return kills;
    }

    /**
     * Sets the kills.
     *
     * @param kills the new kills
     */
    public void setKills(int kills) {
        this.kills = kills;
    }

    /**
     * Gets the controls.
     *
     * @return the controls
     */
    public String getControls() {
        return controls;
    }

    /**
     * Sets the controls.
     *
     * @param controls the new controls
     */
    public void setControls(String controls) {
        this.controls = controls;
    }

    /**
     * Checks if is winner.
     *
     * @return true, if is winner
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     * Sets the winner.
     *
     * @param winner the new winner
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
