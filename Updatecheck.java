
package myhotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Updatecheck extends JFrame  implements ActionListener
{
    JTextField tfroomno,tfname,tfchkintime,tfdeposit,tfpending;
    Choice ccustomer;
    JButton check,update,back;
    Updatecheck()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setForeground(Color.black);
        text.setBounds(90,10,150,30);
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
        
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,130,150,30);
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,138,150,20);
        add(tfname);
        
        
        JLabel lblchkintime=new JLabel("Checkin time");
        lblchkintime.setBounds(50,170,150,30);
        add(lblchkintime);
        
        tfchkintime=new JTextField();
        tfchkintime.setBounds(200,178,150,20);
        add(tfchkintime);
        
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(50,210,150,30);
        add(lbldeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,218,150,20);
        add(tfdeposit);
        
        
        JLabel lblpending=new JLabel("Pending");
        lblpending.setBounds(50,250,150,30);
        add(lblpending);
        
        tfpending=new JTextField();
        tfpending.setBounds(200,258,150,20);
        add(tfpending);
        
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
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
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
                   tfname.setText(rs.getString("name"));
                   tfchkintime.setText(rs.getString("checkintime"));
                   tfdeposit.setText(rs.getString("deposit"));
               }
               ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroomno.getText()+"'");
               
               while(rs2.next())
               {
                   String price =rs2.getString ("price");
                   int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfdeposit.getText());
                   tfpending.setText(""+amountpaid);
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
           String name=tfname.getText();
           String chkintime=tfchkintime.getText();
           String deposit=tfdeposit.getText();
           
           try{
               Conn c=new Conn();
               c.s.executeUpdate("update customer set room ='"+room+"',name='"+name+"',checkintime='"+chkintime+"',deposit='"+deposit+"' where number='"+number+"' ");
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
        new Updatecheck();
    }

}
