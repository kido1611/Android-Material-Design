package id.kido1611.androidmaterialdesign.model;

import android.support.v4.app.Fragment;

/**
 * Created by Kido1611 on 22-Apr-16.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    private boolean separator;
    private Fragment fragment;

    public NavDrawerItem() {
        fragment = null;
    }

    public NavDrawerItem(String title, Fragment fragment) {
        this.showNotify = false;
        this.title = title;
        this.separator = false;
        this.fragment = fragment;
    }

    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
        this.separator = false;
        fragment = null;
    }

    public NavDrawerItem(boolean separator){
        this.separator = separator;
        fragment = null;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public void setFragment(Fragment fragment){
        this.fragment = fragment;
    }

    public Fragment getFragment(){
        return this.fragment;
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
