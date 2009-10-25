/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication4;

/**
 *
 * @author tunn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Button b=new Button("OK");
        Button b2=new Button("Cancel");

        b.addActionListener(new Action(){

            @Override
            public void actionPerformed(Button aThis) {
                System.out.println("Action Performed"+aThis.getText());
            }

        });

        b.addActionListener(new Action(){

            @Override
            public void actionPerformed(Button aThis) {
                System.out.println("Action 2 Performed"+aThis.getText());
            }

        });

        b2.addActionListener(new Action() {
            @Override
            public void actionPerformed(Button aThis) {
                button1Action(aThis);
            }
        });

        b.paint();

        b.click();
    }

    public static void button1Action(Button b) {
        System.out.println("Action Performed"+b.getText());
    }
}
