/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demotablemodel;

/**
 *
 * @author tunn
 */
public class ColumnData {
    
    private String title;
    private int width;
    private int align;
    private boolean visible=false;

    public ColumnData(String title, int width, int align) {
        this.title = title;
        this.width = width;
        this.align = align;
    }

    public int getAlign() {
        return align;
    }

    public void setAlign(int align) {
        this.align = align;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    
}
