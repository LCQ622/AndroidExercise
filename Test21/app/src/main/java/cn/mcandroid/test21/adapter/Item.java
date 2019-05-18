package cn.mcandroid.test21.adapter;

public class Item {
    private  int icon;
    private String Title;
    private String Content;

    public Item() {
    }

    public Item(int icon, String title, String content) {

        this.icon = icon;
        Title = title;
        Content = content;
    }


    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
