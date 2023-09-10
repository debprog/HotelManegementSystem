
package myhotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Addcustomer extends JFrame implements  ActionListener
{
    JTextField tfnumber,tfprice,tfname,tfcountry,tfdeposit;
    JComboBox cbid,cbcleaningstatus,cbbedtype;
    Choice croom;
    JRadioButton rbmale,rbfemale;
    JButton addcust,back;
    JLabel checkintime;
    Addcustomer()
    {
        setLayout(null);
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(60,70,120,30);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblid);
        
        String str[]={"AADHAR","PASSPORT","VOTERID"};
        cbid=new JComboBox(str);
        cbid.setBounds(200, 70, 150, 30);
        cbid.setBackground(Color.white);
        add(cbid);
        
        
        
        JLabel lblnumber=new JLabel("NUMBER");
        lblnumber.setBounds(60,110,120,30);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(200,110,150,30);
        add(tfnumber);
        
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,150,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,190,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        rbmale=new JRadioButton("MALE");
        rbmale.setBounds(200,190,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,12));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        
        rbfemale=new JRadioButton("FEMALE");
        rbfemale.setBounds(271,190,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,12));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();   // only male or female btn is clicked
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lblcountry=new JLabel("COUNTRY");
        lblcountry.setBounds(60,230,120,30);
        lblcountry.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200,230,150,30);
        add(tfcountry);
        
        
        JLabel lblroom=new JLabel("Room Alloted");
        lblroom.setBounds(60,270,120,30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblroom);
        
        
        croom=new Choice();
        
         try
         {
                Conn conn = new Conn();
                String query = "SELECT * from room where available='available'";
                ResultSet rs=conn.s.executeQuery(query);
                
                while(rs.next())
                {
                    croom.add(rs.getString("roomnumber"));
                }
         }
         catch(Exception e)
            {
                e.printStackTrace();
            }

        croom.setBounds(200,270,120,30);
        add(croom);
        
        
        JLabel lbltime=new JLabel("Checkin Time");
        lbltime.setBounds(60,310,120,30);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbltime);
        
        Date date=new Date();
       
        checkintime=new JLabel(""+date);
        checkintime.setBounds(200,310,150,30);
        checkintime.setFont(new Font("Tahoma",Font.PLAIN,10));
        add(checkintime);
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(60,350,120,30);
        lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbldeposit);
        
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,350,150,30);
        add(tfdeposit);
        
        
        addcust=new JButton("ADD");
        addcust.setBackground(Color.BLACK);
        addcust.setForeground(Color.WHITE);
        addcust.setBounds(60,390,100,30);
        addcust.addActionListener(this);
        add(addcust);
        
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250,390,100,30);
        back.addActionListener(this);
        add(back);
        
           
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/cust.png"));
        Image i2=i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,65,450,370);
        add(image);
        
        
        
       
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,100,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==addcust )
        {
            String id =(String)cbid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            String country=tfcountry.getText();
            String room=(String)croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();
        if(rbmale.isSelected())
        {
            gender="Male";
        }
        
        else if (rbfemale.isSelected())
        {
            gender="Female";
        }
        
        try{
                Conn conn = new Conn();
                String query = "INSERT INTO customer values( '"+id+"', '"+number+"', '"+name+"','"+gender+"', '"+country+"', '"+room+"','"+time+"', '"+deposit+"')";
                String query2 = "update room set available='OCCUPIED' where roomnumber='"+room+"'";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "customer added Successfully");
                setVisible(false);
                new Reception();

        }catch(Exception e)
                {
                    e.printStackTrace();
                }

        }
        
        else if (ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
         
        
        
                       
    }
    
    
    public static void main(String args[])
    {
        new Addcustomer();
    }
}
