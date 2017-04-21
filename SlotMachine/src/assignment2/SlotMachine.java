/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thushini
 */
public class SlotMachine {

    private JButton btnReel1, btnReel2, btnReel3, btnSpin, btnAddCoin, btnBetOne, btnBetMax, btnStatistics, btnReset,
            btnSaveStatistics, btnBack;
    private JFrame slotMachineFrame, statisticsFrame;
    private JPanel pnlReels, textArea1, textArea2, textArea3, textArea4, pnlStatistics1, pnlStatistics2, pnlStatistics3,
            pnlStatistics4;
    private JLabel lblCreditArea, lblBetArea, lblWins, lblLosses, lblAverage;

    private int reel1Value = 0, reel2Value = 0, reel3Value = 0, credit = 10, bet = 0, wins = 0, losses = 0, payout = 0,
            totalBettedAmount = 0;
    private double average = 0;
    private ImageIcon reelImage1, reelImage2, reelImage3;
    Reel reel1 = new Reel();
    Reel reel2 = new Reel();
    Reel reel3 = new Reel();

    public static void main(String[] args) {
        SlotMachine gui = new SlotMachine();
        gui.frameComponents();

    }

    public void frameComponents() {

        slotMachineFrame = new JFrame("Slot Machine");
        slotMachineFrame.setLayout(new BorderLayout(7, 3));

        pnlReels = new JPanel();
        pnlReels.setBorder(BorderFactory.createEtchedBorder());

        textArea1 = new JPanel();
        textArea1.setBackground(Color.lightGray);
        textArea1.setBorder(BorderFactory.createEtchedBorder());

        textArea2 = new JPanel();
        textArea2.setBackground(Color.lightGray);
        textArea2.setBorder(BorderFactory.createEtchedBorder());

        textArea3 = new JPanel();
        textArea3.setBackground(Color.lightGray);
        textArea3.setBorder(BorderFactory.createEtchedBorder());

        textArea4 = new JPanel();
        textArea4.setBackground(Color.black);
        textArea4.setBorder(BorderFactory.createEtchedBorder());

        btnReel1 = new JButton();

        btnReel1.setBackground(new Color(50, 50, 150));
        btnReel1.setBorder(new LineBorder(Color.CYAN, 12));
        btnReel2 = new JButton();
        btnReel2.setBackground(new Color(50, 50, 150));
        btnReel2.setBorder(new LineBorder(Color.CYAN, 12));
        btnReel3 = new JButton();
        btnReel3.setBackground(new Color(50, 50, 150));
        btnReel3.setBorder(new LineBorder(Color.CYAN, 12));

        btnSpin = new JButton("Spin");
        btnSpin.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnSpin.setBackground(Color.red);
        btnSpin.setPreferredSize(new Dimension(300, 80));
        btnSpin.setBorder(new LineBorder(Color.BLUE, 12));
        btnSpin.addActionListener(new spin());

        btnAddCoin = new JButton("Add Coin  ");
        btnAddCoin.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnAddCoin.setBackground(Color.red);
        btnAddCoin.setBorder(new LineBorder(Color.PINK, 12));
        btnAddCoin.addActionListener(new addCoin());

        btnBetOne = new JButton("Bet One ");
        btnBetOne.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnBetOne.setBackground(Color.red);
        btnBetOne.setBorder(new LineBorder(Color.PINK, 12));
        btnBetOne.addActionListener(new betOne());

        btnBetMax = new JButton("Bet Max");
        btnBetMax.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnBetMax.setBackground(Color.red);
        btnBetMax.setBorder(new LineBorder(Color.PINK, 12));
        btnBetMax.addActionListener(new betMax());

        btnStatistics = new JButton("Statistics");
        btnStatistics.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnStatistics.setBackground(Color.red);
        btnStatistics.setBorder(new LineBorder(Color.PINK, 12));
        btnStatistics.addActionListener(new statistics());

        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnReset.setBackground(Color.red);
        btnReset.setPreferredSize(new Dimension(300, 80));
        btnReset.setBorder(new LineBorder(Color.BLUE, 12));
        btnReset.addActionListener(new reset());

        lblCreditArea = new JLabel("Credit Area: " + credit);
        lblCreditArea.setFont(new Font("Snap ITC", Font.BOLD, 40));
        lblCreditArea.setBackground(Color.black);
        lblCreditArea.setPreferredSize(new Dimension(300, 500));
        lblBetArea = new JLabel(" Bet Area: " + bet);
        lblBetArea.setFont(new Font("Snap ITC", Font.BOLD, 40));
        lblBetArea.setBackground(Color.BLACK);
        lblBetArea.setPreferredSize(new Dimension(300, 500));

        pnlReels.add(btnReel1);
        pnlReels.add(btnReel2);
        pnlReels.add(btnReel3);
        pnlReels.setLayout(new BoxLayout(pnlReels, BoxLayout.X_AXIS));
        slotMachineFrame.getContentPane().add(BorderLayout.NORTH, pnlReels);

        textArea1.add(btnBetOne);
        textArea1.add(btnBetMax);
        textArea1.setLayout(new BoxLayout(textArea1, BoxLayout.Y_AXIS));
        slotMachineFrame.getContentPane().add(BorderLayout.WEST, textArea1);

        textArea2.add(btnSpin);
        textArea2.add(btnReset);
        textArea2.setLayout(new BoxLayout(textArea2, BoxLayout.X_AXIS));
        textArea2.setLayout(new FlowLayout(FlowLayout.CENTER));
        slotMachineFrame.getContentPane().add(BorderLayout.SOUTH, textArea2);

        textArea3.add(btnAddCoin);
        textArea3.add(btnStatistics);
        textArea3.setLayout(new BoxLayout(textArea3, BoxLayout.Y_AXIS));
        slotMachineFrame.getContentPane().add(BorderLayout.EAST, textArea3);

        textArea4.add(lblCreditArea);
        textArea4.add(lblBetArea);
        textArea4.setLayout(new BoxLayout(textArea4, BoxLayout.Y_AXIS));
        slotMachineFrame.getContentPane().add(BorderLayout.CENTER, textArea4);

        slotMachineFrame.setSize(1670, 900);
        slotMachineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        slotMachineFrame.setVisible(true);

        reelImage1 = new ImageIcon(getClass().getResource("Images/redseven.png"));
        btnReel1.setIcon(reelImage1);
        btnReel2.setIcon(reelImage1);
        btnReel3.setIcon(reelImage1);
    }

    public void spin() {

        btnReel1.setBackground(new Color(50, 50, 150));
        btnReel2.setBackground(new Color(50, 50, 150));
        btnReel3.setBackground(new Color(50, 50, 150));

        if (bet > 0) {
            reel1.spin(reel1.images);
            reel2.spin(reel2.images);
            reel3.spin(reel3.images);

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean run = true;

                    while (run) {
                        if (!btnReel1.getModel().isPressed()) {
                            int i = (int) Math.floor(Math.random() * 5);
                            reelImage1 = new ImageIcon(getClass().getResource(reel1.images.get(i).getImage()));
                            btnReel1.setIcon(reelImage1);
                            reel1Value = reel1.images.get(i).getValue();

                        } else {
                            run = false;
                        }
                    }

                }
            });
            t.start();

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean run1 = true;

                    while (run1) {
                        if (!btnReel2.getModel().isPressed()) {
                            int i1 = (int) Math.floor(Math.random() * 5);
                            reelImage2 = new ImageIcon(getClass().getResource(reel2.images.get(i1).getImage()));
                            btnReel2.setIcon(reelImage2);
                            reel2Value = reel2.images.get(i1).getValue();
                        } else {
                            run1 = false;
                        }
                    }
                }
            });
            t1.start();

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean run2 = true;

                    while (run2) {
                        if (!btnReel3.getModel().isPressed()) {
                            int i2 = (int) Math.floor(Math.random() * 5);
                            reelImage3 = new ImageIcon(getClass().getResource(reel3.images.get(i2).getImage()));
                            reel3Value = reel3.images.get(i2).getValue();
                            btnReel3.setIcon(reelImage3);

                        } else {
                            run2 = false;

                        }
                    }
                    checkPayout();
                }
            });
            t2.start();

        } else {
            JOptionPane.showMessageDialog(null, "Add an amount to bet first");
        }
    }

    public void checkPayout() {

        if (reel1Value == reel2Value || reel2Value == reel3Value || reel3Value == reel1Value) {

            if (reel1Value == reel2Value && reel2Value == reel3Value && reel3Value == reel1Value) {
                btnReel1.setBackground(Color.red);
                btnReel2.setBackground(Color.red);
                btnReel3.setBackground(Color.red);
                payout = reel1Value * bet;
                credit = credit + payout;
                JOptionPane.showMessageDialog(null, "You Have Win " + payout + " credits");
                wins++;
                totalBettedAmount = totalBettedAmount + bet;

            } else if (reel1Value == reel2Value) {
                btnReel1.setBackground(Color.red);
                btnReel2.setBackground(Color.red);
                credit = credit + bet;
                JOptionPane.showMessageDialog(null, "Try Again!!!!");
            } else if (reel2Value == reel3Value) {
                btnReel2.setBackground(Color.red);
                btnReel3.setBackground(Color.red);
                credit = credit + bet;
                JOptionPane.showMessageDialog(null, "Try Again!!!!");
            } else {
                btnReel1.setBackground(Color.red);
                btnReel3.setBackground(Color.red);
                credit = credit + bet;
                JOptionPane.showMessageDialog(null, "Try Again!!!!");
            }

            lblCreditArea.setText("Credit Area: " + credit);
        } else {
            JOptionPane.showMessageDialog(null, "You Lost!!!");
            losses++;
            totalBettedAmount = totalBettedAmount + bet;

        }
        bet = 0;
        payout = 0;
        lblBetArea.setText("Bet Area: " + bet);
        average = (totalBettedAmount / (wins + losses));

    }

    public void addCoin() {
        credit++;
        lblCreditArea.setText("Credit Area: " + credit);
    }

    public void betOne() {
        if (credit > 0) {
            bet++;
            credit--;

            lblBetArea.setText("Bet Area: " + bet);
            lblCreditArea.setText("Credit Area: " + credit);
        } else {
            lblBetArea.setText("Insufficient credit.Add more coins");
        }
    }

    public void betMax() {
        if (credit > 2) {
            bet = bet + 3;
            credit = credit - 3;

            lblBetArea.setText("Bet Area: " + bet);
            lblCreditArea.setText("Credit Area: " + credit);
        } else {
            lblBetArea.setText("Insufficient credit.Add more coins");
        }
    }

    public void statistics() {
        statisticsFrame = new JFrame("Statistics");
        statisticsFrame.setLayout(new BorderLayout(7, 3));

        pnlStatistics1 = new JPanel();
        pnlStatistics1.setBackground(Color.red);

        pnlStatistics2 = new JPanel();
        pnlStatistics2.setBackground(Color.red);
        pnlStatistics2.setPreferredSize(new Dimension(400, 80));

        pnlStatistics3 = new JPanel();
        pnlStatistics3.setBackground(Color.PINK);

        pnlStatistics4 = new JPanel();
        pnlStatistics4.setBackground(Color.black);

        btnSaveStatistics = new JButton("Save Statistics");
        btnSaveStatistics.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnSaveStatistics.setBackground(Color.red);
        btnSaveStatistics.setBorder(new LineBorder(Color.BLUE, 12));
        btnSaveStatistics.addActionListener(new saveStatistics());

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Snap ITC", Font.BOLD, 40));
        btnBack.setBackground(Color.red);
        btnBack.setBorder(new LineBorder(Color.BLUE, 12));
        btnBack.addActionListener(new back());

        lblWins = new JLabel("Wins :  " + wins);
        lblWins.setFont(new Font("Snap ITC", Font.BOLD, 40));
        lblWins.setPreferredSize(new Dimension(300, 80));
        lblWins.setBorder(new LineBorder(Color.BLUE, 12));

        lblLosses = new JLabel("Losses :  " + losses);
        lblLosses.setFont(new Font("Snap ITC", Font.BOLD, 40));
        lblLosses.setPreferredSize(new Dimension(300, 80));
        lblLosses.setBorder(new LineBorder(Color.BLUE, 12));
        lblAverage = new JLabel("Average: " + average);
        lblAverage.setFont(new Font("Snap ITC", Font.BOLD, 40));
        lblAverage.setPreferredSize(new Dimension(300, 80));
        lblAverage.setBorder(new LineBorder(Color.BLUE, 12));

        pnlStatistics1.add(btnSaveStatistics);
        statisticsFrame.getContentPane().add(BorderLayout.WEST, pnlStatistics1);

        pnlStatistics2.add(btnBack);
        statisticsFrame.getContentPane().add(BorderLayout.EAST, pnlStatistics2);

        pnlStatistics3.add(lblWins);
        pnlStatistics3.add(lblLosses);
        pnlStatistics3.add(lblAverage);
        pnlStatistics3.setLayout(new BoxLayout(pnlStatistics3, BoxLayout.Y_AXIS));
        statisticsFrame.getContentPane().add(BorderLayout.CENTER, pnlStatistics3);

        statisticsFrame.setSize(1300, 500);
        statisticsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        statisticsFrame.setVisible(true);

    }

    public void reset() {
        if (bet > 0) {
            credit = credit + bet;
            lblCreditArea.setText("Credit Area: " + credit);
            totalBettedAmount = totalBettedAmount - bet;

            bet = 0;

            lblBetArea.setText("Bet Area: " + bet);
            JOptionPane.showMessageDialog(null, "Bet amount has been reset.");
        } else {
            JOptionPane.showMessageDialog(null, "You haven't add a bet amount to reset.");
        }
    }

    public void saveFile() {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");
        FileWriter statsFW = null;
        try {

            statsFW = new FileWriter(dateFormat.format(date) + ".txt");

            statsFW.write("No of Wins      : " + wins);
            statsFW.write("\r\n");
            statsFW.write("No of Losses    : " + losses);
            statsFW.write("\r\n");
            statsFW.write("Average credit  : " + average);

            statsFW.close();
            JOptionPane.showMessageDialog(null, "File has been Saved.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Saving File.");
        }

    }

    private class spin implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            spin();

        }

    }

    private class addCoin implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            addCoin();
        }
    }

    private class betOne implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            betOne();
        }
    }

    private class betMax implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            betMax();
        }
    }

    private class statistics implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            statistics();
            slotMachineFrame.setVisible(false);

        }
    }

    private class back implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            frameComponents();
            statisticsFrame.setVisible(false);
        }
    }

    private class reset implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            reset();

        }
    }

    private class saveStatistics implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            saveFile();
        }
    }

}
