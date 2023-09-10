
package myhotelmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Adddriver extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,tfcarcompany,tfcarmodel,tflocation;
    JComboBox cbgender,cbcleaningstatus,cbavailable;
    JButton adddriver,cancel;
    Adddriver()    {
         setLayout(null);
        
        
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,70,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(200,70,150,30);
        add(tfage);
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,110,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        String str[]={"MALE","FEMALE"};
        cbgender=new JComboBox(str);
        cbgender.setBounds(200, 110, 150, 30);
        cbgender.setBackground(Color.white);
        add(cbgender);
        
        JLabel lblcarcompany=new JLabel("CAR COMPANY");
        lblcarcompany.setBounds(60,150,120,30);
        lblcarcompany.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcarcompany);
        
        tfcarcompany=new JTextField();
        tfcarcompany.setBounds(200,150,150,30);
        add(tfcarcompany);
        
        JLabel lblcarmodel=new JLabel("CAR MODEL");
        lblcarmodel.setBounds(60,190,120,30);
        lblcarmodel.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblcarmodel);
        
        tfcarmodel=new JTextField();
        tfcarmodel.setBounds(200,190,150,30);
        add(tfcarmodel);
        
        JLabel lblavailable=new JLabel("AVAILABILITY");
        lblavailable.setBounds(60,230,120,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblavailable);
        
        String str1[]={"AVAILABLE"," NOT AVAILABLE"};
        cbavailable=new JComboBox(str1);
        cbavailable.setBounds(200, 230, 150, 30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);
        
        
        JLabel lbllocation=new JLabel("LOCATION");
        lbllocation.setBounds(60,270,120,30);
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbllocation);
        
        tflocation=new JTextField();
        tflocation.setBounds(200,270,150,30);
        add(tflocation);
        
        adddriver=new JButton("ADD DRIVER");
        adddriver.setBackground(Color.BLACK);
        adddriver.setForeground(Color.WHITE);
        adddriver.setBounds(60,310,120,30);
        adddriver.addActionListener(this);
        add(adddriver);
        
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230,310,120,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,30,410,310);
        add(image);
        
        
        
        
        
        
        setBounds(350,200,850,450);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==adddriver)
        {
        String name=tfname.getText();
        String age=tfage.getText();
        String carmodel=tfcarmodel.getText();
        String location=tflocation.getText();
        String carcompany=tfcarcompany.getText();
        String gender=(String)cbgender.getSelectedItem();
        String available=(String)cbavailable.getSelectedItem();
        
           
           try{
                Conn conn = new Conn();
                String query = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+carcompany+"', '"+carmodel+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver added Successfully");
                setVisible(false);
        }catch(Exception e)
                {
                    e.printStackTrace();
                }

        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
        
    }


public static void main(String args[])
{
    new Adddriver();
}

}