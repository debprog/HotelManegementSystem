
package myhotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener {
    
     JTable table;
    JButton back;
    Department()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(200, 10, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("Budget");
        l2.setBounds(600, 10, 100, 20);
        add(l2);
        
      
        
        
        table=new JTable();
        table.setBounds(0,40,800,400);
        add(table);
        
        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from department");
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
        
        setBounds(200,100,800,570);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        setVisible(false);
        new Reception();
    }
    
    
   
    

    
    
public static void main(String args[])
{
    new Department();
}
}