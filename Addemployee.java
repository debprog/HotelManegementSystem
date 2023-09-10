
package myhotelmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;


public class Addemployee extends JFrame implements ActionListener{
    
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    Addemployee()
    {
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
        
        rbmale=new JRadioButton("MALE");
        rbmale.setBounds(200,110,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,12));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        
        rbfemale=new JRadioButton("FEMALE");
        rbfemale.setBounds(271,110,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,12));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();   // only male or female btn is clicked
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,150,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        String str[]={"Front desk","House Keeping","Kitchen Staff","Room Service","Manger"};
         cbjob=new JComboBox(str);
        cbjob.setBounds(200, 150, 150, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);
        
        
        
        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,190,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);
        
         tfsalary=new JTextField();
        tfsalary.setBounds(200,190,150,30);
        add(tfsalary);
        
        JLabel lblphone=new JLabel("PHONE");
        lblphone.setBounds(60,230,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);
        
         tfphone=new JTextField();
        tfphone.setBounds(200,230,150,30);
        add(tfphone);
        
        
         
        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,270,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);
        
         tfemail=new JTextField();
        tfemail.setBounds(200,270,150,30);
        add(tfemail);
        
        JLabel lblaadhar=new JLabel("AADHAR NO.");
        lblaadhar.setBounds(60,310,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);
        
         tfaadhar=new JTextField();
        tfaadhar.setBounds(200,310,150,30);
        add(tfaadhar);
        
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,350,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,65,450,370);
        add(image);
        
        setBounds(350,200,850,450);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    
   
    public void actionPerformed(ActionEvent ae) {
        
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();
        
        String gender=null;
        
        if(rbmale.isSelected())
        {
            gender="Male";
        }
        
        else if (rbmale.isSelected())
        {
            gender="Female";
        }
        
        String job=(String)cbjob.getSelectedItem();
        
        
        
        try{
                Conn conn = new Conn();
                String query = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee added Successfully");
                setVisible(false);
        }catch(Exception e)
                {
                    e.printStackTrace();
                }
                       
    }
    
    public static void main(String args[])
    {
        new Addemployee();

    }
}
