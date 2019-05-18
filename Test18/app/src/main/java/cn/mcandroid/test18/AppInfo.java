package cn.mcandroid.test18;

public class AppInfo {
    private  int APPicon;
    private String Title;;
    private  String Size;

    public AppInfo() {
    }

    public AppInfo(int APPicon, String title, String size) {
        this.APPicon = APPicon;
        Title = title;
        Size = size;
    }

    public int getAPPicon() {
        return APPicon;
    }

    public void setAPPicon(int APPicon) {
        this.APPicon = APPicon;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }
}
