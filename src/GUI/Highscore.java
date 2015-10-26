package GUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class Highscore extends JPanel {
    private JLabel lblHighscore;
    private JLabel lblstPlace;
    private JLabel lbl1score;
    private JLabel lblndPlace;
    private JLabel lbl2score;
    private JLabel lblrdPlace;
    private JLabel lbl3score;
    private JLabel lblthPlace;
    private JLabel lbl4score;
    private JLabel lblthPlace_1;
    private JLabel lbl5score;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public Highscore() {
        setLayout(null);

        lblHighscore = new JLabel("HIGHSCORES");
        lblHighscore.setBounds(426, 117, 161, 33);
        add(lblHighscore);

        lblstPlace = new JLabel("1st place");
        lblstPlace.setBounds(449, 227, 115, 33);
        add(lblstPlace);

        lbl1score = new JLabel("");
        lbl1score.setBounds(366, 278, 282, 38);
        add(lbl1score);

        lblndPlace = new JLabel("2nd place");
        lblndPlace.setBounds(449, 344, 115, 33);
        add(lblndPlace);

        lbl2score = new JLabel("");
        lbl2score.setBounds(366, 405, 282, 38);
        add(lbl2score);

        lblrdPlace = new JLabel("3rd place");
        lblrdPlace.setBounds(449, 467, 115, 33);
        add(lblrdPlace);

        lbl3score = new JLabel("");
        lbl3score.setBounds(366, 515, 282, 38);
        add(lbl3score);

        lblthPlace = new JLabel("4th place");
        lblthPlace.setBounds(449, 581, 115, 33);
        add(lblthPlace);

        lbl4score = new JLabel("");
        lbl4score.setBounds(366, 640, 282, 38);
        add(lbl4score);

        lblthPlace_1 = new JLabel("5th place");
        lblthPlace_1.setBounds(449, 706, 115, 33);
        add(lblthPlace_1);

        lbl5score = new JLabel("");
        lbl5score.setBounds(366, 757, 282, 38);
        add(lbl5score);

        btnBack = new JButton("Back");
        btnBack.setBounds(83, 831, 171, 41);
        add(btnBack);

    }

    public JLabel getLbl1score() {
        return lbl1score;
    }

    public JLabel getLbl2score() {
        return lbl2score;
    }

    public JLabel getLbl3score() {
        return lbl3score;
    }

    public JLabel getLbl4score() {
        return lbl4score;
    }

    public JLabel getLbl5score() {
        return lbl5score;
    }

    public JButton getBtnBack(){
        return btnBack;
    }

    public void addActionListener(ActionListener l){
        btnBack.addActionListener(l);
    }

}

