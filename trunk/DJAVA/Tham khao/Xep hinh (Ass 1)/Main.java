/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dungtv_c0808l_assignment1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Random;
/**
 *
 * @author Dungtv C0808l
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     public static JButton[] button = new JButton[17];
     static int n=16;
     static int b0 =0;
     
     static void startEvent(java.awt.event.MouseEvent evt) {
        Random random = new Random();
        int ok;
        int rd = random.nextInt()%100;
        
        for(int k=0; k<rd; k++)
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n-1; j++){
               ok = random.nextInt() % 2;
               if (ok>0){
                   String temp=button[i].getText();
                   button[i].setText(button[j].getText());
                   button[j].setText(temp);                   
               }
            }
        }
       for (int i=0; i<n; i++){
           if (button[i].getText().equals("")){
                b0 =i;
                break;
           }
       }
       System.out.println("Started...");
    }

    public static void swarp(int a,int b){
                    System.out.println("Swarp "+a+" & "+b);
                   String temp=button[a].getText();
                   button[a].setText(button[b].getText());
                   button[b].setText(temp);
                   b0=b;
    }
    public static int num(String str){
        for(int i=0; i<n; i++){
            if (str.equals(button[i].getText())){
                return i;
            }
        }
        return b0;
    }
            
    public static boolean check(int n1,int n2) {
    	int a=n1;
    	int b=n2;
    	if (a>b){
    		int temp = a;
    		a=b;
    		b=temp;
    	}
    	
        System.out.println("check "+a+" "+b);
        if ((java.lang.Math.abs(a-b)==1)||(java.lang.Math.abs(a-b)==4)){            
        	if(!((a%4==3&&b%4==0)&&(java.lang.Math.abs(a-b)==1))){
        		return true;	
        	}
        	else return false;
            
        }
        else return false;
    }


    public static void main(String[] args) {
        JFrame frame=new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel panel;
        int i;
        panel = new JPanel(new GridLayout(4,4));        
        button[0] = new JButton("");
        panel.add(button[0]);
        for (i=1; i<n; i++){
            button[i] = new JButton(""+i);
            panel.add(button[i]);
        }
        contentPane.add(panel,BorderLayout.CENTER);
        panel = new JPanel(new FlowLayout());
        button[n]=new JButton("Start");
        panel.add(button[n]);
        contentPane.add(panel,BorderLayout.SOUTH);
        frame.setSize(300,300);
        frame.setVisible(true);
        button[n].addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
                startEvent(evt);
            }
        });
        int b1;
        for(b1=0; b1<n; b1++){
            button[b1].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt){
                        String str = ((JButton) evt.getSource()).getText();
                        int b=num(str);
	                    if (check(b0,b)){
	                        swarp(b0,b);
	                    }

                    }

            });
        }

    }

}
