



package myhotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Updateroom extends JFrame  implements ActionListener
{
    JTextField tfroomno,tfname,tfchkintime,tfdeposit,tfpending,tfavailable,tfstatus;
    Choice ccustomer;
    JButton check,update,back;
    Updateroom()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setForeground(Color.black);
        text.setBounds(90,10,250,30);
        add(text);
        
        JLabel id=new JLabel("Customer ID");
        id.setBounds(50,50,150,30);
        add(id);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200,55,150,30);
        add(ccustomer);
        
         try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
        
        
        
        JLabel lblroom=new JLabel("Room No.");
        lblroom.setBounds(50,90,150,30);
        add(lblroom);
        
        tfroomno=new JTextField();
        tfroomno.setBounds(200,98,150,20);
        add(tfroomno);
        
        
        JLabel lblname=new JLabel("Availability");
        lblname.setBounds(50,130,150,30);
        add(lblname);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(200,138,150,20);
        add(tfavailable);
        
        
        JLabel lblchkintime=new JLabel("Cleaning status");
        lblchkintime.setBounds(50,170,150,30);
        add(lblchkintime);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(200,178,150,20);
        add(tfstatus);
        
        
        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        check.setBounds(50, 310, 100, 30);
        add(check);
        
        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setBounds(180, 310, 100, 30);
        add(update);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(300, 310, 100, 30);
        add(back);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(430,50,500,300);
        add(image);
        
        
        
        
        
        

        setBounds(200,100,1000,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
       if(ae.getSource()==check)
       {
           String id =ccustomer.getSelectedItem();
           String query="select * from customer where number='"+id+"' ";
           
           try
           {
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery(query); 
               while(rs.next())
               {
                   tfroomno.setText(rs.getString("room"));
                  
               }
               ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroomno.getText()+"'");
               
               while(rs2.next())
               {
                   tfavailable.setText(rs2.getString("available"));
                   tfstatus.setText(rs2.getString("status"));
                   
               }
           }
           catch(Exception e)
           {
            e.printStackTrace();

           }
       }
       
       else if(ae.getSource()==update)
       {
           String number=ccustomer.getSelectedItem();
           String room=tfroomno.getText();
           String available=tfavailable.getText();
           String status=tfstatus.getText();
           
           
           try{
               Conn c=new Conn();
               c.s.executeUpdate("update room set available ='"+available+"',status='"+status+"'where roomnumber='"+room+"'");
               JOptionPane.showMessageDialog(null,"Updated Successfully");
               
               setVisible(false);
               new Reception();
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
        new Updateroom();
    }

}

