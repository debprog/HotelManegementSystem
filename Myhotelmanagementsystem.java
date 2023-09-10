
package myhotelmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Myhotelmanagementsystem extends JFrame implements ActionListener{

   Myhotelmanagementsystem()
   {
      // setSize(1366,565);
       //setLocation(0,100);
       setBounds(0,100,1366,565);
       setLayout(null);
       
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
       
       JLabel image= new JLabel(i1);
       image.setBounds(0,0,1366,565);
       add(image);
       JLabel text= new JLabel("HOTEL MANAGEMENT SYSTEM");
       text.setBounds(20,430,1000,90);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("serif",Font.PLAIN,50));
       image.add(text);
       
       
       JButton next=new JButton("Next");
       next.setBounds(1150, 450, 150, 50);
       next.setBackground(Color.white);
       next.setForeground(Color.magenta);
       next.addActionListener(this);
       image.add(next);
       setVisible(true);
       
       while(true)  //dipper effect of the label "HOTEL MANAGEMENT SYSTEM"
       {
           text.setVisible(false);
           try
           {
               Thread.sleep(50);
           }catch(Exception e)
           {
               e.printStackTrace();
           }
           text.setVisible(true);
           try
           {
               Thread.sleep(50);
           }catch(Exception e)
           {
               e.printStackTrace();
           }

       }
   }
   
   @Override
   public void actionPerformed(ActionEvent ae)
   {
       setVisible(false);
       new Login();
   }
    public static void main(String[] args) {
       new Myhotelmanagementsystem();
    }
    
}
