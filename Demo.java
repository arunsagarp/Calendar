import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Demo
{
 int a[]={31,28,31,30,31,30,31,31,30,31,30,31};
  public static void main(String aee[])
  {
    new Compute();
  }
}
class Test extends JFrame{
  JButton b[]=new JButton[49];
  JLabel l;
  JPanel p;
  int c=1;
  GridLayout g;
  String s="";
   Test(int m,int y,int n,Demo d)
  {      
    
    switch(m){
    case 1:s="January";break;
    case 2:s="February";break;
    case 3:s="March";break;
    case 4:s="April";break;
    case 5:s="May";break;
    case 6:s="June";break;
    case 7:s="July";break;
    case 8:s="August";break;
    case 9:s="September";break;
    case 10:s="October";break;
    case 11:s="November";break;
    case 12:s="December";break;
    }
    s=s+"  "+y;
    setTitle("Calendar");
    l=new JLabel();
    l.setFont(new Font("Arial",Font.ITALIC,25));
    l.setText(s);
    l.setPreferredSize(new Dimension(50,75));
    add(l,BorderLayout.NORTH);
    p=new JPanel();   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450,450);
    g=new GridLayout(0,7);
    g.setVgap(3);
    g.setHgap(3);
    p.setLayout(g);
    for(int i=0;i<49;i++)
    {
      b[i]=new JButton();
      b[i].setFont(new Font("Arial",Font.BOLD,17));
      b[i].setPreferredSize(new Dimension(20,20));
      p.add(b[i]);
    }
    add(p);
    b[0].setText("S");
    b[0].setForeground(Color.red);
    b[1].setText("M");
    b[2].setText("T");
    b[3].setText("W");
    b[4].setText("Th");
    b[5].setText("F");
    b[6].setText("Sa");
    b[7].setForeground(Color.red);
    b[14].setForeground(Color.red);
    b[21].setForeground(Color.red);
    b[28].setForeground(Color.red);
    b[35].setForeground(Color.red);
    b[42].setForeground(Color.red);
    setVisible(true);  
    n=n%7;
    for(int i=1;i<=d.a[m-1];i++)
    b[n+i+6].setText(i+"");
  
  }
}
class Compute extends JFrame implements ActionListener{
  JLabel l1,l2;
  JTextField t1,t2;
  JButton b;
  Compute(){
    l1=new JLabel("Enter  Year");
    l2=new JLabel("Enter Month");
    t1=new JTextField(10);
    t2=new JTextField(10);
    b=new JButton("OK");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(250,150);
    setTitle("Calendar");
    setResizable(false);
    setLayout(new FlowLayout());
    add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(b);
    b.addActionListener(this);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
          Demo d=new Demo();
          int m=0,t=0,y=0,i,n,sum,x,o;
          try{
          m=Integer.parseInt(t2.getText());
          y=Integer.parseInt(t1.getText());
          }
          catch(Exception ex)
          {
            JOptionPane.showMessageDialog(this,"Enter in digits");
            return; 
          }
          t=y;
          if(y%400==0)
          d.a[m-1]=29;
    else if(y%100==0)
    d.a[m-1]=28;
    else if(y%4==0)
      d.a[m-1]=29;
    y=y-1;
          y=y%400;
          sum=5*(y/100);
          y=y%100;
          x=y/4;
          sum=sum+x*2+(y-x);
          for(i=0;i<m-1;i++)
          sum=sum+d.a[i];
          sum=sum+1;
          new Test(m,t,sum,d);
          setVisible(false);
      }
    }
        