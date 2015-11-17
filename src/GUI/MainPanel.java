package GUI;

import javax.swing.*;
import javax.xml.soap.Detail;
import java.awt.*;

/**
 * Created by Oscar on 17-11-2015.
 */
public class MainPanel extends JPanel {

    private static final String LOGIN = "LOGIN";
    private static final String MENU = "MENU";
    private static final String DELETEGAME = "DELETE_GAME";
    private static final String PLAYSNAKE = "PLAY_SNAKE";
    private static final String JOINGAME = "JOIN_GAME";
    private static final String HIGHSCORE = "HIGHSCORE";

    // private Frame frame = new Frame();
    private Login login;
    private Menu menu;
    private DeleteGame deleteGame;
    private PlaySnake playSnake;
    private JoinGame joinGame;
    private Highscore highscore;

    private CardLayout c;

    public MainPanel(){

        setOpaque(false);
        setVisible(true);

        c = new CardLayout();
        setLayout(c);

        login = new Login();
        add(login, LOGIN);

        menu = new Menu();
        add(menu, MENU);

        highscore = new Highscore();
        add(highscore, HIGHSCORE);

        joinGame = new JoinGame();
        add(joinGame, JOINGAME);

        playSnake = new PlaySnake();
        add(playSnake, PLAYSNAKE);

        deleteGame = new DeleteGame();
        add(deleteGame, DELETEGAME);


        c.show(this, LOGIN);


    }

    public Login getLogin() {
        return login;
    }

    public Menu getMenu() {
        return menu;
    }

    public DeleteGame getDeleteGame() {
        return deleteGame;
    }

    public Highscore getHighscore() {
        return highscore;
    }

    public JoinGame getJoinGame() {
        return joinGame;
    }

    public PlaySnake getPlaySnake() {
        return playSnake;
    }

    public CardLayout getC() {
        return c;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getMENU() {
        return MENU;
    }

    public static String getDELETEGAME() {
        return DELETEGAME;
    }

    public static String getHIGHSCORE() {
        return HIGHSCORE;
    }

    public static String getJOINGAME() {
        return JOINGAME;
    }

    public static String getPLAYSNAKE() {
        return PLAYSNAKE;
    }
}
