import java.time.Period;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;
public class AgeCalculator {
    JLabel head1,l2,l3,l4,l5,l6,l7,l8,result;
    JButton btn;
    JTextField tf,tf1,tf2,tf3,tf4,tf5,tf6;
    Period pd;
    
    AgeCalculator()
    {
        JFrame f=new JFrame("Age Calculator");
        f.setSize(500,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        head1=new JLabel("Start Date ");
        head1.setBounds(50,50,100,17);
        f.add(head1);
        
        tf1=new JTextField("00");
        tf1.addMouseListener((MouseListener)new ListenMouse());
        tf1.setBounds(180, 50, 60, 20);
        f.add(tf1);
        
        l3=new JLabel("DD");
        l3.setBounds(200,20,60,20);
        
        f.add(l3);
        
        tf2=new JTextField("00");
        tf2.addMouseListener((MouseListener)new ListenMouse());
        tf2.setBounds(250, 50, 60, 20);
        f.add(tf2);
        
        l4=new JLabel("MM");
        l4.setBounds(270,20,60,20);
        f.add(l4);
        
        tf3=new JTextField("0000");
        tf3.addMouseListener((MouseListener)new ListenMouse());
        tf3.setBounds(320, 50, 60, 20);
        f.add(tf3);
        
        l5=new JLabel("YYYY");
        l5.setBounds(335,20,60,20);
        f.add(l5);
        
        l2=new JLabel("End Date ");
        l2.setBounds(50,65,100,50);
        f.add(l2);
        
        tf4=new JTextField("00");
        tf4.addMouseListener((MouseListener)new ListenMouse());
        tf4.setBounds(180,80,60,20);
        f.add(tf4);
        
        tf5=new JTextField("00");
        tf5.addMouseListener((MouseListener)new ListenMouse());
        tf5.setBounds(250,80,60,20);
        f.add(tf5);
        
        tf6=new JTextField("0000");
        tf6.addMouseListener((MouseListener)new ListenMouse());
        tf6.setBounds(320,80,60,20);
        f.add(tf6);
        
        result=new JLabel();
        result.setBounds(50,100,50,50);
        f.add(result);
        
        l6=new JLabel();
        l6.setBounds(180,100,100,50);
        f.add(l6);
        
        l7=new JLabel();
        l7.setBounds(250,100,150,50);
        f.add(l7);
        
        l8=new JLabel();
        l8.setBounds(320,100,150,50);
        f.add(l8);
        
        btn=new JButton("Calculate");
        btn.addActionListener(new ListenKeyboard());
        btn.setBounds(150,160,150,30);
        f.add(btn);
    }
    class ListenMouse implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
            if((JTextField)e.getSource()==tf1)
            {
                tf=tf1;
            }
            else if((JTextField)e.getSource()==tf2)
                tf=tf2;
            else if((JTextField)e.getSource()==tf3)
                tf=tf3;
            else if((JTextField)e.getSource()==tf4)
                tf=tf4;
            else if((JTextField)e.getSource()==tf5)
                tf=tf5;
            else
                tf=tf6;
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {} 
    }
    class ListenKeyboard implements ActionListener
    {
        int sd,sm,syear;
        int ed,em,eyear;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String date=tf1.getText();
            String date2=tf4.getText();
            if(date.length()==2 && date2.length()==2)
            {
                 sd=Integer.parseInt(date);
                 ed=Integer.parseInt(date2);
            }
            String mnth=tf2.getText();
            String mnth2=tf5.getText();
            if(mnth.length()==2 && mnth2.length()==2)
            {
                sm=Integer.parseInt(mnth);
                em=Integer.parseInt(mnth2);
            }
            String yr=tf3.getText();
            String yr2=tf6.getText();
            if(yr.length()==4 && yr2.length()==4)
            {
                syear=Integer.parseInt(yr);
                eyear=Integer.parseInt(yr2);
            }
            
            //calculation
            LocalDate d1=LocalDate.of(syear,sm,sd);
            LocalDate d2=LocalDate.of(eyear,em,ed);
            
            pd=Period.between(d1,d2);
            result.setText("AGE:- ");
            l6.setText(Integer.toString(pd.getYears())+" Years");
            l7.setText(Integer.toString(pd.getMonths())+" Months");
            l8.setText(Integer.toString(pd.getDays())+" Days old");
        }
    }
    public static void main(String[] args)
    {
        
        AgeCalculator obj=new AgeCalculator();
    }
}
