package id.kido1611.drawerwithrecyclerview.model;

/**
 * Created by Kido1611 on 22-Apr-16.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    private boolean separator;


    public NavDrawerItem() {

    }

    public NavDrawerItem(String title) {
        this.showNotify = false;
        this.title = title;
        this.separator = false;
    }

    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
        this.separator = false;
    }

    public NavDrawerItem(boolean separator){
        this.separator = separator;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSeparator(){
        return this.separator;
    }
}
