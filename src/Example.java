import com.sun.tools.javac.comp.Enter;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Example extends JFrame  {

    private final static String newline = "\n";


    public static void main(String[] args) {
        final JFrame window = new JFrame("Simple Chat");

        ImageIcon img = new ImageIcon("java.png");
        window.setIconImage(img.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JTextField textField = new JTextField(1);
        textField.setMinimumSize(new Dimension(50, 25));
        textField.setPreferredSize(new Dimension(50, 25));
        textField.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        textField.getDocument().putProperty("filterNewlines", Boolean.TRUE);


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(500,500));




        JButton sendButton = new JButton("Send");
        textField.addKeyListener
                (new KeyAdapter() {
                     public void keyPressed(KeyEvent e) {
                         int key = e.getKeyCode();
                         if (key == KeyEvent.VK_ENTER) {
                             String text = textField.getText().trim();
                             if (text.length() > 0) {
                                 textArea.append(text + newline);
                                 textField.selectAll();
                                 textField.setText("");
                                 textField.requestFocusInWindow();
                             }
                         }
                     }
                 }
                );


        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                if (text.length() > 0) {
                    textArea.append(text + newline);
                    textField.selectAll();
                    textField.setText("");
                    textField.requestFocusInWindow();
                }
            }

        });



        panel.add(textArea,Component.RIGHT_ALIGNMENT);
        panel.add(textField,Component.RIGHT_ALIGNMENT);
        panel.add(sendButton, Component.RIGHT_ALIGNMENT);





        window.getContentPane().add(panel);


        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);


        textField.requestFocusInWindow();

    }



}