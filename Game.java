/* Liyao Zhang
    CSC111 Spring 2018
    Programming Assignment 4 – Part 2
    April 28, 2018

    This class creates a JFrame and three GUI elements. Also, when the buttons are clicked, a statement will be printed.*/
package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Game extends JFrame implements ActionListener, ChangeListener {                                         //Set up GUI elements and output fields
    BlackJack nmsl = new BlackJack();
    private JPanel jrbs;
    public static JButton HitMe;
    public static JButton Stay;
    public static JButton Deal;
    public static JButton NewGame;
    public static JButton Print;
    private JLabel DealerScore;
    private JLabel YourScore;
    private JLabel DealerWins;
    private JLabel YourWins;
    private JLabel DealerCard;
    private JLabel YourCard;
    private JLabel NM;
    public static JTextField Ins;
    public static JTextField DS;
    public static JTextField YS;
    public static JTextField DW;
    public static JTextField YW;
    public static JTextField DC;
    public static JTextField YC;
    private JCheckBox jcb;
    FileOutputStream fileByteStream;
    PrintWriter outFS;

    public Game(){                                                                                                     //Initialize the GUI elements
        super("BlackJack");
        GridBagConstraints layoutConst = new GridBagConstraints();
        HitMe = new JButton("Hit Me");                                                                           //Name the buttons and labels
        Stay = new JButton("Stay");
        Deal = new JButton("Deal");
        NewGame = new JButton("New Game");
        Print = new JButton("Print");
        DealerScore = new JLabel("Dealer's Score:");
        YourScore = new JLabel("Your Score:");
        DealerWins = new JLabel("Dealer's Wins:");
        YourWins = new JLabel("Your Wins:");
        DealerCard = new JLabel("Dealer's Card:");
        YourCard = new JLabel("Your Card:");
        NM = new JLabel("Night Mode");
        jcb = new JCheckBox();
        DS = new JTextField();
        YS = new JTextField();
        DW = new JTextField();
        YW = new JTextField();
        DC = new JTextField();
        YC = new JTextField();
        Ins = new JTextField();
        jrbs = new DrawingWindow();
        DS.setPreferredSize(new Dimension(60,30));                                                       //Determine the size of text fields
        YS.setPreferredSize(new Dimension(60,30));
        DW.setPreferredSize(new Dimension(60,30));
        YW.setPreferredSize(new Dimension(60,30));
        DC.setPreferredSize(new Dimension(60,30));
        YC.setPreferredSize(new Dimension(60,30));
        Ins.setPreferredSize(new Dimension(270,30));
        HitMe.setEnabled(false);                                                                                       //Set the buttons to be not usable at first
        Deal.setEnabled(false);
        Stay.setEnabled(false);
        DS.setEditable(false);                                                                                         //Set these text fields to be uneditable
        YS.setEditable(false);
        DW.setEditable(false);
        YW.setEditable(false);
        DC.setEditable(false);
        YC.setEditable(false);
        Ins.setEditable(false);
        Ins.setText("Please press New Game button to start or restart");                                          //Prompt the player in the instruction textfield
        try{
            fileByteStream = new FileOutputStream("C:\\Users\\张力铫\\Desktop\\scores.txt");               //Create output stream to open a file
            outFS = new PrintWriter(fileByteStream);}
            catch (IOException excpt){
            }

        setLayout(new GridBagLayout());                                                                                //Use the GridBagLayout to arrange the positions

        layoutConst.gridx = 4;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(jcb, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(NM, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 3;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(Ins, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(NewGame, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(YourScore, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(YS, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(DealerScore, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(DS, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(YourCard, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(YC, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(DealerCard, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(DC, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(DealerWins, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(DW, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(YourWins, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(YW, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(HitMe, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(Deal, layoutConst);

        layoutConst.gridx = 4;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(Stay, layoutConst);

        layoutConst.gridx = 5;
        layoutConst.gridy = 5;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(Print, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(20, 30, 20, 30);
        add(jrbs, layoutConst);

        pack();
        setVisible(true);                                                                                               //Make the GUI elements visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                                //Terminate the program when the close tab is clicked

        HitMe.addActionListener(this);                                                                               //Add action/change listeners of buttons and the checkbox
        Deal.addActionListener(this);
        Stay.addActionListener(this);
        NewGame.addActionListener(this);
        Print.addActionListener(this);
        jcb.addChangeListener(this);
        setDayMode();                                                                                                   //Set Day Mode to be default
    }

    @Override
    public void actionPerformed(ActionEvent event) {                                                                   //Respond to user's actions
        JButton sourceEvent = (JButton)event.getSource();
        if (sourceEvent==HitMe){
            nmsl.hit();
            System.out.println("The Hit Me button was clicked");
        } else if (sourceEvent==Deal){
            nmsl.deal();
            HitMe.setEnabled(true);
            Stay.setEnabled(true);
            Deal.setEnabled(false);
            System.out.println("The Deal button was clicked");
        }else if (sourceEvent==Stay){
            HitMe.setEnabled(false);
            nmsl.stay();
            System.out.println("The Stay button was clicked");

        }else if (sourceEvent==Print){                                                                                 //Call method in BlackJack class to convert "win" to local variable "wins"
            int[] wins = {0,0};
            System.out.println("The Print button was clicked");
            nmsl.output(wins);
            outFS.println("Your Wins: "+wins[0]);
            outFS.println("Dealer's Wins: "+wins[1]);
            outFS.flush();
        }
        else if (sourceEvent==NewGame){
            nmsl = new BlackJack();
            nmsl.newgame();
            Deal.setEnabled(true);
            YS.setText(""+0);
            DS.setText(""+0);
            Ins.setText("Press deal button to get two cards");
            System.out.println("The New Game button was clicked");
            JOptionPane.showMessageDialog(this, "Welcome To BlackJack !");
        }
    }

    private void setNightMode() {
        getContentPane().setBackground(new Color(100,100,100));
    }
    private void setDayMode() {
        getContentPane().setBackground(new Color(255,255,255));
    }
    public void OptionPane1(){                                                                                         //Create three methods to display an option pane that tells who wins
        JOptionPane.showMessageDialog(this, "You Win!");
    }
    public void OptionPane2(){
        JOptionPane.showMessageDialog(this, "Dealer Wins.");
    }
    public void OptionPane3(){
        JOptionPane.showMessageDialog(this, "It's a Tie.");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(jcb.isSelected()) {
            setNightMode();
        } else {
            setDayMode();
        }
    }
}