public class Person {
    private String name;
    private String birthday;
    private int idCard;


    public Person() {
    }

    public Person(String name, String birthday, int idCard){
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public int getIdCard() {
        return idCard;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String display() {
        return "Tên : " + this.getName() + "\nNgày sinh : "+ this.getBirthday()+"\nSố CMT/CCCD : "+ this.getIdCard() +"";
    }
}
