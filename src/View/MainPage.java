/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Main.LoginPage;
import View.Dosen.ViewDataDsn;
import View.Mahasiswa.ViewDataMhs;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Lab Informatika
 */
public class MainPage extends JFrame implements ActionListener {
    JLabel header = new JLabel();
    JLabel subheader = new JLabel("Silahkan Pilih Untuk Melanjutkan");
    JLabel label1 = new JLabel("Informasi Data Mahasiswa");
    JLabel label2 = new JLabel("Informasi Data Dosen");
    
            
    JButton tombolMhs = new JButton("Mahasiswa");
    JButton tombolDsn = new JButton("Dosen");
    JButton tombolKeluar = new JButton("Logout");
    
    public MainPage(String user){
        setTitle("Main Page");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 540);
        
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(header);
        add(subheader);
        add(label1);
        add(label2);
        add(tombolMhs);
        add(tombolDsn);
        add(tombolKeluar);
        
        header.setBounds(20, 8, 440, 24);
        header.setFont(new Font("arial", Font.BOLD, 19));
        header.setText("Selamat Datang " + user);
        subheader.setBounds(20, 30, 440, 24);
        subheader.setFont (new Font("arial", Font.BOLD, 13));
        label1.setBounds(78, 80, 240, 40);
        tombolMhs.setBounds(30, 120, 240, 40);
        label2.setBounds(340, 80, 240, 40);
        tombolDsn.setBounds(280, 120, 240, 40);
        tombolKeluar.setBounds(30, 180, 490, 35);
        
        tombolMhs.addActionListener(this);
        tombolDsn.addActionListener(this);
        tombolKeluar.addActionListener(this);
    }

    public MainPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==tombolMhs){
                dispose();
                new ViewDataMhs();
            } else if(e.getSource()==tombolDsn){
                dispose();
                new ViewDataDsn();
            } else if(e.getSource()==tombolKeluar){
                new LoginPage();
            }
        } catch(Exception error){
            JOptionPane.showMessageDialog(null,"Database belum terhubung, \n tolong nyalakan XAMPP");
            System.exit(0);
        }
    }
}
