
package myhotelmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard()
    {
        setBounds(0,0,1920,1080);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel (i3);
        image.setBounds(0,0, 1920,1080);
        add(image);
        
        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(300, 80, 1000, 50);
        text.setFont(new Font("Tahoma",Font.PLAIN,50));
        text.setForeground(Color.WHITE); 
        image.add(text);
        
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0  , 0, 1920, 20);
        image.add(mb);
        
        
        
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.magenta);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.magenta);
        mb.add(admin);
        
        JMenuItem employee = new JMenuItem("ADD EMPLOYEE");
        employee.addActionListener(this);
        admin.add(employee);
        
         JMenuItem room = new JMenuItem("ADD ROOM");
         room.addActionListener(this);
        admin.add(room);
        
         JMenuItem driver = new JMenuItem("ADD DRIVER");
         driver.addActionListener(this);
        admin.add(driver);
        
        

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new Addemployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOM"))
        {
            new Addrooms();
        }
         else if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception();
        }
        
        else if(ae.getActionCommand().equals("ADD DRIVER"))
        {
            new Adddriver();
        }
        
    }

    
    
    
    
    public static void main(String args[])
    {
        new Dashboard();
    }
}
