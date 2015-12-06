package GUI;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 17-11-2015.
 */
public class MainPanel extends JPanel {

    /** The Constant LOGIN. */
    private static final String LOGIN = "LOGIN";
    
    /** The Constant MENU. */
    private static final String MENU = "MENU";
    
    /** The Constant DELETEGAME. */
    private static final String DELETEGAME = "DELETE_GAME";
    
    /** The Constant PLAYSNAKE. */
    private static final String PLAYSNAKE = "PLAY_SNAKE";
    
    /** The Constant JOINGAME. */
    private static final String JOINGAME = "JOIN_GAME";
    
    /** The Constant HIGHSCORE. */
    private static final String HIGHSCORE = "HIGHSCORE";
    
    /** The Constant CREATEUSER. */
    private static final String CREATEUSER = "CREATEUSER";
    
    /** The Constant CREATEGAME. */
    private static final String CREATEGAME = "CREATEGAME";

    private static final String LOADING = "LOADING";

    private static final String GAMEINFO = "GAMEINFO";

    /** The login. */
    private final Login login;
    
    /** The menu. */
    private final Menu menu;
    
    /** The delete game. */
    private final DeleteGame deleteGame;
    
    /** The play snake. */
    private final PlaySnake playSnake;
    
    /** The join game. */
    private final JoinGame joinGame;
    
    /** The highscore. */
    private final Highscore highscore;

    /** The create user. */
    private final CreateUser createUser;
    
    /** The create game. */
    private final CreateGame createGame;

    private final GameInfo gameInfo;

    /** The c. */
    private final CardLayout c;

    /**
     * Instantiates a new main panel.
     */
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

        createUser = new CreateUser();
        add(createUser, CREATEUSER);

        createGame = new CreateGame();
        add(createGame, CREATEGAME);

        Loading loading = new Loading();
        add(loading, LOADING);

        gameInfo = new GameInfo();
        add(gameInfo, GAMEINFO);

        c.show(this, LOGIN);
    }

    /**
     * Gets the login.
     *
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * Gets the menu.
     *
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Gets the delete game.
     *
     * @return the delete game
     */
    public DeleteGame getDeleteGame() {
        return deleteGame;
    }

    /**
     * Gets the highscore.
     *
     * @return the highscore
     */
    public Highscore getHighscore() {
        return highscore;
    }

    /**
     * Gets the join game.
     *
     * @return the join game
     */
    public JoinGame getJoinGame() {
        return joinGame;
    }

    /**
     * Gets the play snake.
     *
     * @return the play snake
     */
    public PlaySnake getPlaySnake() {
        return playSnake;
    }

    /**
     * Gets the creates the user.
     *
     * @return the creates the user
     */
    public CreateUser getCreateUser() {
        return createUser;
    }

    /**
     * Gets the creates the game.
     *
     * @return the creates the game
     */
    public CreateGame getCreateGame() {
        return createGame;
    }

    /**
     * Gets the c.
     *
     * @return the c
     */
    public CardLayout getC() {
        return c;
    }

    /**
     * Gets the login.
     *
     * @return the login
     */
    public static String getLOGIN() {
        return LOGIN;
    }

    /**
     * Gets the menu.
     *
     * @return the menu
     */
    public static String getMENU() {
        return MENU;
    }

    /**
     * Gets the deletegame.
     *
     * @return the deletegame
     */
    public static String getDELETEGAME() {
        return DELETEGAME;
    }

    /**
     * Gets the highscore.
     *
     * @return the highscore
     */
    public static String getHIGHSCORE() {
        return HIGHSCORE;
    }

    /**
     * Gets the joingame.
     *
     * @return the joingame
     */
    public static String getJOINGAME() {
        return JOINGAME;
    }

    /**
     * Gets the playsnake.
     *
     * @return the playsnake
     */
    public static String getPLAYSNAKE() {
        return PLAYSNAKE;
    }

    /**
     * Gets the createuser.
     *
     * @return the createuser
     */
    public static String getCREATEUSER() {
        return CREATEUSER;
    }

    /**
     * Gets the creategame.
     *
     * @return the creategame
     */
    public static String getCREATEGAME() {
        return CREATEGAME;
    }

    public static String getLOADING() {
        return LOADING;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public static String getGAMEINFO() {
        return GAMEINFO;
    }
}
