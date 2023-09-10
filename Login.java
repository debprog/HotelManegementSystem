
package myhotelmanagementsystem;

import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JTextField username;
   
    JButton login,cancel;
    JPasswordField password;
    
    Login()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel user=new JLabel("USERNAME");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
        username=new JTextField();
        username.setBounds(150, 20, 100, 30);
        add(username);
        
         
        JLabel pass=new JLabel("PASSWORD");
        pass.setBounds(40, 60, 100, 30);
        add(pass);
        
        password=new JPasswordField();
        password.setBounds(150, 60, 100, 30);
        add(password);
        
        login=new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
       Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(350,10,200,200);
       add(image);

        setBounds(500,200,600,300);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()== login)
       {
           String user =username.getText();
           String pass=password.getText();
           
           try{
               Conn c=new Conn();
               String query="select * from login where username='"+user+"' and password1='"+pass+"'";;
               ResultSet rs= c.s.executeQuery(query);
               //System.out.println(pass);
              if (rs.next())
              {
                setVisible(false);
                new Dashboard();
               


              }
              else 
              {
                  JOptionPane.showMessageDialog(null,"INVALID");
                  setVisible(false);

                  
              }
           }
           
           catch(Exception e)
           {
               e.printStackTrace();
           }
       }
       else if(ae.getSource()== cancel)
       {
           setVisible(false);
       }
   }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
