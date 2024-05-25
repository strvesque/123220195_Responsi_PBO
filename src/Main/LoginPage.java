/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.MainPage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lab Informatika
 */
public class LoginPage extends JFrame implements ActionListener {
    JLabel header = new JLabel("Selamat Datang!");
    JLabel subheader = new JLabel("Silahkan masuk untuk melanjutkan.");
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    
    JTextField inputusername = new JTextField();
    JPasswordField inputpassword = new JPasswordField();
    
    JButton loginbutton = new JButton("Login");
    
    LoginPage(){
        
        setVisible(true);
        setSize(552, 540); 
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        
        add(header);
        header.setFont(new Font("arial", Font.BOLD, 19));
        header.setBounds(20, 8, 440, 24);
       
        add(subheader);
        subheader.setFont (new Font("arial", Font.BOLD, 13));
        subheader.setBounds(20, 30, 440, 24);
        
        add(username);
        username.setBounds(20, 86, 440, 24);
        
        add(password);
        password.setBounds(20, 180, 440, 24);
        
        add(inputusername);
        inputusername.setBounds(18, 110, 440, 36);
        
        add(inputpassword);
        inputpassword.setBounds(18, 204, 440, 36);
        
        add(loginbutton);
        loginbutton.setBounds(15, 275, 455, 35);
        loginbutton.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String user = inputusername.getText();
            String password = inputpassword.getText();
             
            if (user.isEmpty() && password.isEmpty()){
                throw new Exception("Username dan Password Tidak Boleh Kosong!");
            } else if (user.isEmpty()){
                throw new Exception("Username Tidak Boleh Kosong!");
            } else if (password.isEmpty()){
                throw new Exception("Password Tidak Boleh Kosong!");
            }
            
                        new MainPage(user);
            this.dispose();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
        
    }

}
