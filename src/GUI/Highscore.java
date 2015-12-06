package GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;


// TODO: Auto-generated Javadoc
/**
 * The Class Highscore.
 */
public class Highscore extends JPanel {
    
    /** The lbl highscore. */
    private JLabel lblHighscore;
    
    /** The lbl1st place. */
    private JLabel lbl1stPlace;
    
    /** The lbl1score. */
    private JLabel lbl1score;
    
    /** The lbl2nd place. */
    private JLabel lbl2ndPlace;
    
    /** The lbl2score. */
    private JLabel lbl2score;
    
    /** The lbl3rd place. */
    private JLabel lbl3rdPlace;
    
    /** The lbl3score. */
    private JLabel lbl3score;
    
    /** The lbl4th place. */
    private JLabel lbl4thPlace;
    
    /** The lbl4score. */
    private JLabel lbl4score;
    
    /** The lbl5th place. */
    private JLabel lbl5thPlace;
    
    /** The lbl5score. */
    private JLabel lbl5score;
    
    /** The btn back. */
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public Highscore() {

        Methods methods = new Methods();

        setLayout(null);
        setOpaque(false);

        lblHighscore = new JLabel("HIGHSCORES");
        lblHighscore.setBounds(737, 200, 525, 85);
        methods.fontColor(lblHighscore);
        methods.setFontHeadline(lblHighscore);
        methods.setAlignment(lblHighscore);
        add(lblHighscore);

        lbl1stPlace = new JLabel("1st place");
        lbl1stPlace.setBounds(875, 350, 250, 35);
        methods.fontColor(lbl1stPlace);
        methods.setFontLabel(lbl1stPlace);
        methods.setAlignment(lbl1stPlace);
        add(lbl1stPlace);

        lbl1score = new JLabel("");
        lbl1score.setBounds(750, 410, 500, 35);
        methods.fontColor(lbl1score);
        methods.setFontLabel(lbl1score);
        methods.setAlignment(lbl1score);
        add(lbl1score);

        lbl2ndPlace = new JLabel("2nd place");
        lbl2ndPlace.setBounds(875, 505, 250, 35);
        methods.fontColor(lbl2ndPlace);
        methods.setFontLabel(lbl2ndPlace);
        methods.setAlignment(lbl2ndPlace);
        add(lbl2ndPlace);

        lbl2score = new JLabel("");
        lbl2score.setBounds(750, 575, 500, 35);
        methods.fontColor(lbl2score);
        methods.setFontLabel(lbl2score);
        methods.setAlignment(lbl2score);
        add(lbl2score);

        lbl3rdPlace = new JLabel("3rd place");
        lbl3rdPlace.setBounds(875, 670, 250, 35);
        methods.fontColor(lbl3rdPlace);
        methods.setFontLabel(lbl3rdPlace);
        methods.setAlignment(lbl3rdPlace);
        add(lbl3rdPlace);

        lbl3score = new JLabel("");
        lbl3score.setBounds(750, 740, 500, 35);
        methods.fontColor(lbl3score);
        methods.setFontLabel(lbl3score);
        methods.setAlignment(lbl3score);
        add(lbl3score);

        lbl4thPlace = new JLabel("4th place");
        lbl4thPlace.setBounds(875, 835, 250, 35);
        methods.fontColor(lbl4thPlace);
        methods.setFontLabel(lbl4thPlace);
        methods.setAlignment(lbl4thPlace);
        add(lbl4thPlace);

        lbl4score = new JLabel("");
        lbl4score.setBounds(750, 905, 500, 35);
        methods.fontColor(lbl4score);
        methods.setFontLabel(lbl4score);
        methods.setAlignment(lbl4score);
        add(lbl4score);

        lbl5thPlace = new JLabel("5th place");
        lbl5thPlace.setBounds(875, 1000, 250, 35);
        methods.fontColor(lbl5thPlace);
        methods.setFontLabel(lbl5thPlace);
        methods.setAlignment(lbl5thPlace);
        add(lbl5thPlace);

        lbl5score = new JLabel("");
        lbl5score.setBounds(750, 1070, 500, 35);
        methods.fontColor(lbl5score);
        methods.setFontLabel(lbl5score);
        methods.setAlignment(lbl5score);
        add(lbl5score);

        btnBack = new JButton("Back");
        btnBack.setBounds(800, 1280, 400, 100);
        btnBack.setFont(methods.getFontLabel());
        add(btnBack);

    }

    /**
     * Gets the lbl5score.
     *
     * @return the lbl5score
     */
    public JLabel getLbl5score() {
        return lbl5score;
    }

    /**
     * Gets the lbl4score.
     *
     * @return the lbl4score
     */
    public JLabel getLbl4score() {
        return lbl4score;
    }

    /**
     * Gets the lbl3score.
     *
     * @return the lbl3score
     */
    public JLabel getLbl3score() {
        return lbl3score;
    }

    /**
     * Gets the lbl2score.
     *
     * @return the lbl2score
     */
    public JLabel getLbl2score() {
        return lbl2score;
    }

    /**
     * Gets the lbl1score.
     *
     * @return the lbl1score
     */
    public JLabel getLbl1score() {
        return lbl1score;
    }

    /**
     * Gets the btn back.
     *
     * @return the btn back
     */
    public JButton getBtnBack(){
        return btnBack;
    }

    /**
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l){
        btnBack.addActionListener(l);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0,0, getWidth(),getHeight());
        graphics2D.setComposite(old);
    }

}

