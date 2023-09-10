/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Addrooms extends JFrame implements ActionListener {
    JTextField tfroomnumber,tfprice;
    JComboBox cbavailable,cbcleaningstatus,cbbedtype;
    JButton addroom,cancel;
    Addrooms()
    {
         setLayout(null);
        
        
        JLabel lblroomnumber=new JLabel("ROOM NUMBER");
        lblroomnumber.setBounds(60,30,120,30);
        lblroomnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblroomnumber);
        
        tfroomnumber=new JTextField();
        tfroomnumber.setBounds(200,30,150,30);
        add(tfroomnumber);
        
        JLabel lblavailable=new JLabel("AVAILABLE");
        lblavailable.setBounds(60,70,120,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblavailable);
        
        String str[]={"AVAILABLE","OCCUPIED"};
        cbavailable=new JComboBox(str);
        cbavailable.setBounds(200, 70, 150, 30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);
        
        JLabel lblcleaningstatus=new JLabel("Cleaning Status");
        lblcleaningstatus.setBounds(60,110,120,30);
        lblcleaningstatus.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcleaningstatus);
        
        String str1[]={"cleaned","NOT CLEANED"};
        cbcleaningstatus=new JComboBox(str1);
        cbcleaningstatus.setBounds(200, 110, 150, 30);
        cbcleaningstatus.setBackground(Color.white);
        add(cbcleaningstatus);
        
        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(60,150,120,30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,150,150,30);
        add(tfprice);
        
        
        JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setBounds(60,190,120,30);
        lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblbedtype);
        
          
        String str2[]={"Single bed","Double bed","Triple Bed"};
        cbbedtype=new JComboBox(str2);
        cbbedtype.setBounds(200, 190, 150, 30);
        cbbedtype.setBackground(Color.white);
        add(cbbedtype);
        
        addroom=new JButton("ADD ROOM");
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.setBounds(60,230,100,30);
        addroom.addActionListener(this);
        add(addroom);
        
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(250,230,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(370,30,450,300);
        add(image);
        
        
        setBounds(350,200,850,450);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==addroom)
        {
           String roomnumber=tfroomnumber.getText();
           String available=(String)cbavailable.getSelectedItem();
           String status=(String)cbcleaningstatus.getSelectedItem();
           String price=tfprice.getText();
           String type=(String)cbbedtype.getSelectedItem();
           
            try{
                 Conn conn = new Conn();
                 String query = "INSERT INTO room values( '"+roomnumber+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Room added Successfully");
                 setVisible(false);
         }catch(Exception e)
                 {
                     e.printStackTrace();
                 }

         }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
        
    }
        
        
        
        
        
        
    public static void main(String args[])
    {
        new Addrooms();
        

    }
    
}
