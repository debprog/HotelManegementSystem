
package myhotelmanagementsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.util.Date;


public class Checkout extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit,checkout;
    JComboBox cbbded;
    Choice ccustid;
    JCheckBox chkavailable;
    JLabel lblroomno,lblchkintime,lblchkouttime;
    
    Checkout()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(140, 30, 100, 20);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lblcustid=new JLabel("Customer id");
        lblcustid.setBounds(20, 70, 100, 20);
        //lblcustid.setForeground(Color.BLUE);
        //lblcustid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblcustid);
        
        ccustid=new Choice();
        ccustid.setBounds(120,70,150,30);
        ccustid.setBackground(Color.white);
        add(ccustid);
        
       
           
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(210,65,150,30);
        add(image);
        
        
        
        JLabel lblroom=new JLabel("Room no");
        lblroom.setBounds(20, 100, 100, 20);
        add(lblroom);
        
        lblroomno=new JLabel("dfadf");
        lblroomno.setBounds(120, 100, 100, 20);
        add(lblroomno);
        
        
        JLabel lblchkin=new JLabel("Check In time");
        lblchkin.setBounds(20, 130, 100, 20);
        add(lblchkin);
        
        lblchkintime=new JLabel("dfadf");
        lblchkintime.setBounds(120, 130, 180, 20);
        add(lblchkintime);
        
        
        JLabel lblchkout=new JLabel("Check Out time");
        lblchkout.setBounds(20, 160, 100, 20);
        add(lblchkout);
        
        Date date=new Date();
        lblchkouttime=new JLabel(""+date);
        lblchkouttime.setBounds(120, 160, 180, 20);
        add(lblchkouttime);
        
        
        checkout=new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        checkout.setBounds(40, 250, 120, 30);
        add(checkout);
        
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200, 250, 120, 30);
        add(back);
        
          try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                ccustid.add(rs.getString("number"));
                lblroomno.setText(rs.getString("room"));
                lblchkintime.setText(rs.getString("checkintime"));
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(450, 250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image1=new JLabel(i6);
        image1.setBounds(350,50,400,250);
        add(image1);
        
        
        
        
        
        
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
       if(ae.getSource()==checkout)
       {
          String query1 ="delete from customer where number='"+ccustid.getSelectedItem()+"' ";
          String query2 ="update room set available='Available' where roomnnumber='"+lblroomno.getText()+"'";
          
          try{
              Conn c=new Conn();
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              
              JOptionPane.showMessageDialog(null,"Check out Done");
              setVisible(false);
              new Reception();
              
          }
          catch(Exception e)
          {
           e.printStackTrace();
          }
          
       }
       
       else
       {
           setVisible(false);
           new Reception();
       }
    }
    public static void main(String args[])
    {
        new Checkout();
    }
    
    
}
