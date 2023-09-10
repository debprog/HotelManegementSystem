
package myhotelmanagementsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    Room()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
           
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,500,600);
        add(image);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(5, 10, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("Availabity");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(200, 10, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Deposit");
        l4.setBounds(310, 10, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Room Type");
        l5.setBounds(410, 10, 100, 20);
        add(l5);
        
        
        
        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);
        
        setBounds(200,100,1000,570);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    }
    
    public static void main(String args[])
    {
        new Room();
    }
    
}
