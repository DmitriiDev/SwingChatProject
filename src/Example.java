import com.sun.tools.javac.comp.Enter;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Example extends JFrame  {

    private final static String newline = "\n";


    public static void main(String[] args) {
        final JFrame window = new JFrame("Simple Chat");

        ImageIcon img = new ImageIcon("java.png");
        window.setIconImage(img.getImage());

        JTextField textField = new JTextField(1);
        textField.setBackground(Color.WHITE);
        textField.getDocument().putProperty("filterNewlines", Boolean.TRUE);


        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.white);
        textArea.setEditable(false);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        JButton sendButton = new JButton("Send");
        sendButton.setVerticalTextPosition(AbstractButton.CENTER);
        sendButton.setHorizontalTextPosition(AbstractButton.RIGHT);
        textField.addKeyListener
                (new KeyAdapter() {
                     public void keyPressed(KeyEvent e) {
                         int key = e.getKeyCode();
                         if (key == KeyEvent.VK_ENTER) {
                             String text = textField.getText();
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
                String text = textField.getText();
                if (text.length() > 0) {
                    textArea.append(text + newline);
                    textField.selectAll();
                    textField.setText("");
                    textField.requestFocusInWindow();
                }
            }

        });


        panel.add(textArea);
        panel.add(textField);
        panel.add(sendButton);


        window.getContentPane().add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(300, 200);
        textField.requestFocusInWindow();

    }



}