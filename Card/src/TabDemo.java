/**
 * Created by sam on 12/12/17.
 */
import java.awt.*;
import javax.swing.*;

public class TabDemo {
    final static String BUTTONPANEL = "Tab with JButtons";
    final static String TEXTPANEL = "Tab with JTextField";
    final static int extraWindowWidth = 100;

    public void addComponentToPane(container pane){
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel card1 = new JPanel(){
            public Dimension getPreferredSize(){
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField)
    }
}
