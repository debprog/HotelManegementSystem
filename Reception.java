
package myhotelmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton newcustomerform,room,department,allempinfo,custinfo,manginfo,checkout,updtsts,updtroomsts,pickup,searchroom,logout;
    
    Reception()
    {
        newcustomerform=new JButton("New Customer Form");
        newcustomerform.setBackground(Color.BLACK);
        newcustomerform.setForeground(Color.WHITE);
        newcustomerform.setBounds(60,30,150,30);
        newcustomerform.addActionListener(this);
        add(newcustomerform);
        
        
        room=new JButton("Room");
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        room.setBounds(60,70,150,30);
        room.addActionListener(this);
        add(room);
        
        department=new JButton("Department");
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setBounds(60,110,150,30);
        department.addActionListener(this);
        add(department);
        
        allempinfo=new JButton("All Employee Info");
        allempinfo.setBackground(Color.BLACK);
        allempinfo.setForeground(Color.WHITE);
        allempinfo.setBounds(60,150,150,30);
        allempinfo.addActionListener(this);
        add(allempinfo);
        
        custinfo=new JButton("Customer Info");
        custinfo.setBackground(Color.BLACK);
        custinfo.setForeground(Color.WHITE);
        custinfo.setBounds(60,190,150,30);
        custinfo.addActionListener(this);
        add(custinfo);
        
        manginfo=new JButton("Manager Info");
        manginfo.setBackground(Color.BLACK);
        manginfo.setForeground(Color.WHITE);
        manginfo.setBounds(60,230,150,30);
        manginfo.addActionListener(this);
        add(manginfo);
        
        checkout=new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(60,270,150,30);
        checkout.addActionListener(this);
        add(checkout);
        
        updtsts=new JButton("Update Status");
        updtsts.setBackground(Color.BLACK);
        updtsts.setForeground(Color.WHITE);
        updtsts.setBounds(60,310,150,30);
        updtsts.addActionListener(this);
        add(updtsts);
        
        updtroomsts=new JButton("Update Room Status");
        updtroomsts.setBackground(Color.BLACK);
        updtroomsts.setForeground(Color.WHITE);
        updtroomsts.setBounds(60,350,150,30);
        updtroomsts.addActionListener(this);
        add(updtroomsts);
        
        pickup=new JButton("Pickup Services");
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.setBounds(60,390,150,30);
        pickup.addActionListener(this);
        add(pickup);
        
        searchroom=new JButton("Search Room");
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.setBounds(60,430,150,30);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout=new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setBounds(60,470,150,30);
        logout.addActionListener(this);
        add(logout);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
         
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,100,800,570);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==newcustomerform)
        {
            setVisible(false);
            new Addcustomer();
        }
        
        else if(ae.getSource()==room)
        {
            setVisible(false);
            new Room();
        }
        
        else if(ae.getSource()==department)
        {
            setVisible(false);
            new Department();
        }
        
        else if(ae.getSource()==allempinfo)
        {
            setVisible(false);
            new Employeeinfo();
        }
        
        else if(ae.getSource()==manginfo)
        {
            setVisible(false);
            new Managerinfo();
        }
        
        
        else if(ae.getSource()==custinfo)
        {
            setVisible(false);
            new Customerinfo();
        }
        
        
         else if(ae.getSource()==searchroom)
        {
            setVisible(false);
            new Searchrooms();
        }
        
        
           else if(ae.getSource()==updtsts)
        {
            setVisible(false);
            new Updatecheck();
        }
        
        else if(ae.getSource()==updtroomsts)
        {
            setVisible(false);
            new Updateroom();
        }
        
         else if(ae.getSource()==pickup)
        {
            setVisible(false);
            new Pickup();
        }
        
         else if(ae.getSource()==checkout)
        {
            setVisible(false);
            new Checkout();
        }
        
         else if(ae.getSource()==logout)
         {
             setVisible(false);
             System.exit(0);
         }
        
        
        
        
     }
    
    public static void main(String args[])
    {
         new Reception();
    }
}
