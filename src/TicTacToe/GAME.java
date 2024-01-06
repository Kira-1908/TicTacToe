package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
//import java.swing.*;

public class GAME implements ActionListener {

    Random rndm = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel text = new JLabel();
    JButton buttons[] = new JButton[9];
    boolean plyr1Turn;

    GAME(){

        //Frames
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.getContentPane().setBackground(new Color(30,30,30));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //Text
        text.setBackground(new Color(20, 20, 20));
        text.setForeground(new Color(227, 222, 200));
        text.setFont(new Font("Ink Free", Font.BOLD, 90));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("TIC-TAC-TOE");
        text.setOpaque(true);

        //Title Panel
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,600,100);

        //Button Panel
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(125,125, 125));

        //Adding
        titlePanel.add(text);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        //buttons
        for(int i = 0; i<9; i++){
            buttons[i] = new JButton();

            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        firstTurn();
    }

    @Override
    public void actionPerformed (ActionEvent e){
        for(int i = 0; i<9; i++) {
            if (e.getSource() == buttons[i]) {
                if (plyr1Turn) {
                    if (buttons[i].getText() =="") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("X");
                        plyr1Turn = false;
                        text.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("O");
                        plyr1Turn = true;
                        text.setText("X turn");
                        check();
                    }
                }
            }

        }

    }


    public void firstTurn(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(rndm.nextInt(2)==0){
            plyr1Turn = true;
            text.setText("X turn");
        }
        else {
            plyr1Turn = false;
            text.setText("O turn");
        }

    }

    public void check(){
        
        //Check xWins 
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWins(0, 1, 2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWins(3, 4, 5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(6, 7, 8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(0, 3, 6);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(0, 4, 8);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWins(1, 4, 7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(2, 5, 8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(2, 4, 6);
        }
        
        //Check OWins
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            OWins(0, 1, 2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            OWins(3, 4, 5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            OWins(6, 7, 8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            OWins(0, 3, 6);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            OWins(0, 4, 8);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            OWins(1, 4, 7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            OWins(2, 5, 8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            OWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("X WINS");

    }

    public void OWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("O WINS");

    }


}



