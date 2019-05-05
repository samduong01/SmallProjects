/**
 * Created by sam on 1/3/18.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
public class Calc implements ActionListener{
    static int count = 0;
    public static void drawGui(){

        JFrame f = new JFrame("Calc");

        JTextArea t1 = new JTextArea("Display");
        t1.setBounds(25,0,250,150);

        JTextField t2 = new JTextField("Enter a calculation");
        t2.setBounds(25,150,250,50);

        JButton click = new JButton("+");
        click.setBounds(5,200,50,50);

        JButton click2 = new JButton("-");
        click2.setBounds(60,200,50,50);



        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                t2.setText(Integer.toString(count + 1));
                count++;

            }
        });
        f.setSize(300,500);
        f.add(t1);
        f.add(t2);
        f.add(click);
        f.add(click2);


        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args){
        drawGui();
    }

    @Override
    public void actionPerformed(ActionEvent arg0){

    }
}
