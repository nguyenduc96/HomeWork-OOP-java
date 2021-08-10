import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int idCard;
        int choice = -1;
        System.out.print("Nhập kích thước mảng : ");
        int size = scanner.nextInt();
        scanner.nextLine();
        Hotel[] hotels = createArrayHotel(size, scanner);
        do {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    hotels = addCustomerInArray(hotels, scanner);
                    break;
                }
                case 2: {
                    System.out.println("KHÁCH HÀNG THANH TOÁN ");
                    System.out.print("Nhập số CMT/CCCD : ");
                    idCard = scanner.nextInt();
                    if (findIndexCustomer(hotels, idCard) != -1) {
                        System.out.println("THÔNG TIN TRẢ PHÒNG : \n" + hotels[findIndexCustomer(hotels, idCard)].displayHotel());
                        System.out.println("SỐ TIỀN PHẢI THANH TOÁN : " + hotels[findIndexCustomer(hotels, idCard)].payment() + "VNĐ");
                    } else {
                        System.out.println("Không tìm thấy khách hàng có số CMT/CCCD : " + idCard);
                    }
                    hotels = deleteCustomerInArray(hotels, idCard);
                    break;
                }
                case 3: {
                    for (int i = 0; i < hotels.length; i++) {
                        System.out.println("THÔNG TIN KHÁCH HÀNG " + (i + 1) + " : \n" + hotels[i].displayHotel());
                    }
                    break;
                }
                case 4: {
                    System.out.println("TÌM KIẾM KHÁCH HÀNG");
                    System.out.print("Nhập số CMT/CCCD : ");
                    idCard = scanner.nextInt();
                    if (findIndexCustomer(hotels, idCard) != -1) {
                        System.out.println("THÔNG TIN TÌM KIẾM : \n" + hotels[findIndexCustomer(hotels, idCard)].displayHotel());
                    } else {
                        System.out.println("Không tìm thấy khách hàng có số CMT/CCCD : " + idCard);
                    }
                    break;
                }
                case 5: {
                    System.out.println("ĐÃ SẮP XẾP");
                    sortCustomer(hotels);
                    break;
                }
                case 6: {
                    System.out.println("Nhập số thứ tự khách hàng muốn sửa bắt đầu từ số 0 và cuối cùng là " + (hotels.length - 1) + "");
                    System.out.println("Hiện tại đang có : " + hotels.length + " khách hàng");
                    int idCustomer = scanner.nextInt();
                    scanner.nextLine();
                    if (findIndex(hotels, idCustomer) != -1) {
                        System.out.println("TRƯỚC UPDATE \n" + hotels[idCustomer].displayHotel());
                        System.out.println("SỬA THÔNG TIN");
                        System.out.println("1: Sửa tên");
                        System.out.println("2: Sửa ngày sinh");
                        System.out.println("3: Sửa số CMT/CCCD");
                        System.out.println("4: Sửa loại phòng");
                        System.out.println("5: Sửa giá phòng");
                        System.out.println("6: Sửa số ngày lưu trú");
                        System.out.println("MỜI BẠN LỰA CHỌN");
                        int choiceEdit = scanner.nextInt();
                        scanner.nextLine();
                        switch (choiceEdit) {
                            case 1: {
                                System.out.print("Nhập tên mới : ");
                                String nameEdit = scanner.nextLine();
                                hotels[idCustomer].getPerson().setName(nameEdit);
                                break;
                            }
                            case 2: {
                                System.out.print("Nhập ngày sinh mới : ");
                                String birthDayEdit = scanner.nextLine();
                                hotels[idCustomer].getPerson().setBirthday(birthDayEdit);
                                break;
                            }
                            case 3: {
                                System.out.print("Nhập số CMT/CCCD mới : ");
                                int idCardEdit = scanner.nextInt();
                                scanner.nextLine();
                                hotels[idCustomer].getPerson().setIdCard(idCardEdit);
                                break;
                            }
                            case 4: {
                                System.out.print("Nhập loại phòng mới : ");
                                String roomTypeEdit = scanner.nextLine();
                                hotels[idCustomer].setRoomTpye(roomTypeEdit);
                                break;
                            }
                            case 5: {
                                System.out.print("Nhập giá phòng mới : ");
                                int priceEdit = scanner.nextInt();
                                scanner.nextLine();
                                hotels[idCustomer].setPrice(priceEdit);
                                break;
                            }
                            case 6: {
                                System.out.print("Nhập số ngày lưu trú mới : ");
                                int stayDayEdit = scanner.nextInt();
                                scanner.nextLine();
                                hotels[idCustomer].setStayDay(stayDayEdit);
                                break;
                            }
                            default: {
                                System.out.println("Số nhập không đúng. Mời thao tác lại!!!");
                            }
                        }
                        System.out.println("SAU UPDATE : \n" + hotels[idCustomer].displayHotel());
                    } else {
                        System.out.println("NHẬP id SAI! HÃY THAO TÁC LẠI");
                    }
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Số nhập không có trong menu. Mời nhập lại");
                    break;
                }
            }

        } while (choice != 0);
    }

    public static Hotel[] createArrayHotel(int size, Scanner scanner) {
        Hotel[] hotels = new Hotel[size];
        for (int i = 0; i < size; i++) {
            System.out.println("THÔNG TIN KHÁCH HÀNG " + (i + 1) + " : ");
            System.out.print("Họ và tên : ");
            String name = scanner.nextLine();
            System.out.print("Ngày sinh (dd/mm/yyyy) : ");
            String birthDay = scanner.nextLine();
            System.out.print("Số CMT/CCCD : ");
            int idCard = scanner.nextInt();
            Person person = new Person(name, birthDay, idCard);
            scanner.nextLine();
            System.out.println("THÔNG TIN PHÒNG " + (i + 1));
            System.out.print("Loại phòng : ");
            String roomType = scanner.nextLine();
            System.out.print("Giá phòng : ");
            int price = scanner.nextInt();
            System.out.print("Số ngày lưu trú : ");
            int stayDay = scanner.nextInt();
            scanner.nextLine();
            hotels[i] = new Hotel(roomType, price, stayDay, person);
        }
        return hotels;
    }

    public static int findIndexCustomer(Hotel[] hotels, int idCard) {
        int index = -1;
        for (int i = 0; i < hotels.length; i++) {
            if (hotels[i].getPerson().getIdCard() == idCard) {
                index = i;
                break;
            }
            index = -1;
        }
        return index;
    }

    public static int findIndex(Hotel[] hotels, int idCustomer) {
        int index = -1;
        for (int i = 0; i < hotels.length; i++) {
            if (idCustomer == i) {
                index = i;
                break;
            }
            index = -1;
        }
        return index;
    }

    public static Hotel[] addCustomerInArray(Hotel[] hotels, Scanner scanner) {
        Hotel[] newHotelArray = new Hotel[hotels.length + 1];
        System.out.println("THÔNG TIN KHÁCH HÀNG MỚI");
        System.out.print("Họ và tên : ");
        String name = scanner.nextLine();
        System.out.print("Ngày sinh (dd/mm/yyyy) : ");
        String birthDay = scanner.nextLine();
        System.out.print("Số CMT/CCCD : ");
        int idCard = scanner.nextInt();
        scanner.nextLine();
        Person person = new Person(name, birthDay, idCard);
        System.out.println("THÔNG TIN PHÒNG");
        System.out.print("Loại phòng : ");
        String roomType = scanner.nextLine();
        System.out.print("Giá phòng : ");
        int price = scanner.nextInt();
        System.out.print("Số ngày lưu trú : ");
        int stayDay = scanner.nextInt();
        scanner.nextLine();
        newHotelArray[hotels.length] = new Hotel(roomType, price, stayDay, person);
        return newHotelArray;
    }

    public static Hotel[] deleteCustomerInArray(Hotel[] hotels, int idCard) {
        Hotel[] newHotelArray = new Hotel[hotels.length - 1];
        int index = findIndexCustomer(hotels, idCard);
        if (index == -1) {
            newHotelArray = hotels;
        } else {
            for (int i = 0; i < hotels.length - 1; i++) {
                if (i < index) {
                    newHotelArray[i] = hotels[i];
                } else {
                    newHotelArray[i] = hotels[i + 1];
                }
            }
        }
        return newHotelArray;
    }

    public static void sortCustomer(Hotel[] hotels) {
        for (int i = 0; i < hotels.length; i++) {
            for (int j = 0; j < hotels.length; j++) {
                if (hotels[i].getPerson().getName().compareTo(hotels[j].getPerson().getName()) < 0) {
                    Hotel temp = hotels[i];
                    hotels[i] = hotels[j];
                    hotels[j] = temp;
                }
            }
        }
    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println("1: Khách vào");
        System.out.println("2: Khách ra/ thanh toán");
        System.out.println("3: Hiển thị toàn bộ khách hàng");
        System.out.println("4: Tìm kiếm khách hàng");
        System.out.println("5: Sắp xếp khách hàng theo tên A - Z");
        System.out.println("6: Sửa thông tin");
        System.out.println("0: Thoát khỏi hệ thống");
    }
}
