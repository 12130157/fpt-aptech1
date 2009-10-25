/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication4;

import java.util.ArrayList;

/**
 *
 * @author tunn
 */
public class Button {
    private ArrayList<Action> action=new ArrayList<Action>();
    private String text;
    public Button() {

    }

    public Button(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void paint() {
        System.out.println(text);
    }

    public void addActionListener(Action action) {
        this.action.add(action);
    }

    public void click() {
        for(Action a:action) {
            a.actionPerformed(this);
        }
        
    }
}
