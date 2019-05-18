package cn.mcandroid.test15.db;

public class Info {
    private  int id;
    private String name;
    private String phone_number;

    private  int Up_id;
    private String Up_name;
    private String Up_phone_number;

    public Info() {
    }

    public Info(int id, String name, String phone_number) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }


    public int getUp_id() {
        return Up_id;
    }

    public void setUp_id(int up_id) {
        Up_id = up_id;
    }

    public String getUp_name() {
        return Up_name;
    }

    public void setUp_name(String up_name) {
        Up_name = up_name;
    }

    public String getUp_phone_number() {
        return Up_phone_number;
    }

    public void setUp_phone_number(String up_phone_number) {
        Up_phone_number = up_phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
