


package myhotelmanagementsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Customerinfo()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Document");
        l1.setBounds(30, 10, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("Number");
        l2.setBounds(130, 10, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(230, 10, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Gender");
        l4.setBounds(340, 10, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Country");
        l5.setBounds(430, 10, 100, 20);
        add(l5);
        
        JLabel l6=new JLabel("Room");
        l6.setBounds(530, 10, 100, 20);
        add(l6);
        
        JLabel l7=new JLabel("CheckinTime");
        l7.setBounds(610, 10, 100, 20);
        add(l7);
        
        
        JLabel l8=new JLabel("Deposit");
        l8.setBounds(730, 10, 100, 20);
        add(l8);
        
        
        
        
        
        
        
        
        
      
        
        
        table=new JTable();
        table.setBounds(0,40,800,400);
        add(table);
        
        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
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
        back.setBounds(350, 500, 120, 30);
        add(back);
        
        setBounds(200,100,820,570);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    }
    
    
    
    
    
    public static void main(String args[])
{
    new Customerinfo();
}
}


