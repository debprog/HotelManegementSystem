package myhotelmanagementsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox cbbded;
    Choice ctypeofcar;
    JCheckBox chkavailable;
    Pickup()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
           
        JLabel text=new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400, 30, 500, 30);
        add(text);
        
        JLabel lblbed=new JLabel("Car Type");
        lblbed.setBounds(140, 69, 80, 20);
        add(lblbed);
        
        ctypeofcar=new Choice();
        ctypeofcar.setBounds(230,70,150,30);
        ctypeofcar.setBackground(Color.white);
        add(ctypeofcar);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                ctypeofcar.add(rs.getString("carmodel"));
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
     

        
        JLabel l1=new JLabel("Name");
        l1.setBounds(5, 180, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(200, 180, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(330, 180, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Car Company");
        l4.setBounds(450, 180, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Car Model");
        l5.setBounds(610, 180, 100, 20);
        add(l5);
        
        JLabel l6=new JLabel("Available");
        l6.setBounds(760, 180, 100, 20);
        add(l6);
        
         JLabel l7=new JLabel("Location");
        l7.setBounds(880, 180, 100, 20);
        add(l7);
        
        
        
         table=new JTable();
        table.setBounds(0,200,1000,250);
        add(table);
        
        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from driver");
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
        back.setBounds(550, 480, 120, 30);
        add(back);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(350, 480, 120, 30);
        add(submit);
        
        
       
        
        setBounds(200,100,1000,570);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
       if(ae.getSource()==submit)
       {
           try
           {
             String query="Select * from driver  where carmodel='"+ctypeofcar.getSelectedItem()+"' ";
            
             
             Conn conn=new Conn();
             ResultSet rs;
             rs=conn.s.executeQuery(query);   
             table.setModel(DbUtils.resultSetToTableModel(rs));

       }
           catch(Exception e)
           {
               e.printStackTrace();
           }
       }
       else if(ae.getSource()==back)
       {
           setVisible(false);
           new Reception();
       }
    }
    
    public static void main(String args[])
    {
        new Pickup();
    }
    
}


