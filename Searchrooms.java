

package myhotelmanagementsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Searchrooms extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox cbbded;
    JCheckBox chkavailable;
    Searchrooms()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
           
        JLabel text=new JLabel("Search Rooms");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400, 30, 500, 30);
        add(text);
        
        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(140, 69, 100, 20);
        add(lblbed);
        
        String str[]={"Single bed","Double","Triple Bed"};
        cbbded=new JComboBox(str);
        cbbded.setBounds(200, 70, 150, 20);
        cbbded.setBackground(Color.white);
        add(cbbded);
        
        chkavailable=new JCheckBox("Only Display Available");
        chkavailable.setBackground(Color.WHITE);
        chkavailable.setBounds(700, 70, 150, 20);
        add(chkavailable);

        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(5, 180, 100, 20);
        add(l1);
        
        JLabel l2=new JLabel("Availabity");
        l2.setBounds(200, 180, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(400, 180, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Deposit");
        l4.setBounds(600, 180, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Room Type");
        l5.setBounds(800, 180, 100, 20);
        add(l5);
        
        
        
         table=new JTable();
        table.setBounds(0,200,1000,250);
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
             String query1="Select * from room  where type='"+cbbded.getSelectedItem()+"' ";
             String query2="Select * from room where available='available' AND type='"+cbbded.getSelectedItem()+"' ";
             
             Conn conn=new Conn();
             ResultSet rs;
             
             if(chkavailable.isSelected())
             {
              rs=conn.s.executeQuery(query2);   
             }
             else
             {
              rs=conn.s.executeQuery(query1);   

             }
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
        new Searchrooms();
    }
    
}

