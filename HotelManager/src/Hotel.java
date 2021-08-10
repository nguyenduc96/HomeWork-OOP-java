public class Hotel {
    private String roomTpye;
    private int price;
    private int stayDay;
    private Person person;

    public Hotel() {}

    public Hotel(String roomTpye, int price, int stayDay, Person person){
        this.roomTpye = roomTpye;
        this.price = price;
        this.stayDay = stayDay;
        this.person = person;
    }

    public String getRoomTpye() {
        return roomTpye;
    }

    public int getStayDay() {
        return stayDay;
    }

    public int getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    public void setRoomTpye(String roomTpye) {
        this.roomTpye = roomTpye;
    }

    public void setStayDay(int stayDay) {
        this.stayDay = stayDay;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int payment(){
        return this.stayDay * this.price;
    }

    public String displayHotel() {
        return "THÔNG TIN KHÁCH HÀNG : \n" + getPerson().display() + "\nLoại phòng : " + getRoomTpye() + "\nGía phòng : " + getPrice() + "\nSố ngày trọ : " + getStayDay() + "";
    }
}
