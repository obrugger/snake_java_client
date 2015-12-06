package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.event.ActionListener;


/**
 * The CreateGame class.
 * Contains the CreateGame JPanel.
 *
 * @author Oscar
 * @since 26-10-2015
 *
 * Created by Oscar on 26-10-2015.
 */
public class CreateGame extends JPanel {

    /** The lbl create game. */
    private JLabel lblCreateGame;
    
    /** The lbl enter gamename. */
    private JLabel lblEnterGamename;
    
    /** The lbl enter mapsize. */
    private JLabel lblEnterMapsize;
    
    /** The lbl enter controls. */
    private JLabel lblEnterControls;

    /** The txt gamename. */
    private JTextField txtGamename;
    
    /** The txt mapsize. */
    private JTextField txtMapsize;
    
    /** The txt controls. */
    private JTextField txtControls;

    /** The btn create. */
    private JButton btnCreate;
    
    /** The btn cancel. */
    private JButton btnCancel;

    /** The methods. */
    private Methods methods;


    /**
     * Creates the CreateGame constructor.
     */
    public CreateGame(){

        /*
        Sets opaque to false.
        It means that the JPanel is transparent.
         */
        setOpaque(false);

        //Sets the layour to be absolute.
        setLayout(null);

        //Initialize Methods variable.
        methods = new Methods();


        lblCreateGame = new JLabel("CREATE GAME");
        lblCreateGame.setBounds(760, 200, 480, 81);
        methods.fontColor(lblCreateGame);
        methods.setAlignment(lblCreateGame);
        methods.setFontHeadline(lblCreateGame);
        add(lblCreateGame);

        lblEnterGamename = new JLabel("Enter game name");
        lblEnterGamename.setBounds(875, 395, 250, 35);
        methods.fontColor(lblEnterGamename);
        methods.setAlignment(lblEnterGamename);
        methods.setFontLabel(lblEnterGamename);
        add(lblEnterGamename);

        txtGamename = new JTextField();
        txtGamename.setBounds(825, 455, 350, 60);
        methods.setAlignmentText(txtGamename);
        methods.setFontText(txtGamename);
        add(txtGamename);
        txtGamename.setColumns(10);

        lblEnterMapsize = new JLabel("Enter map size");
        lblEnterMapsize.setBounds(905, 630, 190, 35);
        methods.fontColor(lblEnterMapsize);
        methods.setAlignment(lblEnterMapsize);
        methods.setFontLabel(lblEnterMapsize);
        add(lblEnterMapsize);

        txtMapsize = new JTextField();
        txtMapsize.setBounds(825, 690, 350, 60);
        methods.setAlignmentText(txtMapsize);
        methods.setFontText(txtMapsize);
        add(txtMapsize);

        lblEnterControls = new JLabel("Enter controls");
        lblEnterControls.setBounds(905, 865, 190, 35);
        methods.fontColor(lblEnterControls);
        methods.setAlignment(lblEnterControls);
        methods.setFontLabel(lblEnterControls);
        add(lblEnterControls);

        txtControls = new JTextField();
        txtControls.setBounds(825, 925, 350, 60);
        methods.setAlignmentText(txtControls);
        methods.setFontText(txtControls);
        add(txtControls);
        txtControls.setColumns(10);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(425, 1100, 400, 100);
        add(btnCreate);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(1175, 1100, 400, 100);
        add(btnCancel);



    }

    /**
     * Gets the btn create.
     *
     * @return the btn create
     */
    public JButton getBtnCreate() {
        return btnCreate;
    }

    /**
     * Gets the btn cancel.
     *
     * @return the btn cancel
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }

    /**
     * Gets the gamename.
     *
     * @return the gamename
     */
    public String getGamename(){
        return txtGamename.getText();
    }

    /**
     * Gets the mapsize.
     *
     * @return the mapsize
     */
    public int getMapsize(){
        return Integer.parseInt(txtMapsize.getText());
    }

    /**
     * Gets the controls.
     *
     * @return the controls
     */
    public String getControls(){
        return txtControls.getText();
    }

    /**
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l) {

        btnCancel.addActionListener(l);
        btnCreate.addActionListener(l);

    }

    /**
     * Clear txt.
     */
    public void clearTxt(){

        txtControls.setText("");
        txtGamename.setText("");
        txtMapsize.setText("");
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
