package cn.mcandroid.test20;

public class Appinfo {
    private int iv;
    private String Title;
    private String Content;

    public Appinfo() {
    }

    public Appinfo(int iv, String title, String content) {
        this.iv = iv;
        Title = title;
        Content = content;
    }

    public int getIv() {
        return iv;
    }

    public void setIv(int iv) {
        this.iv = iv;
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
