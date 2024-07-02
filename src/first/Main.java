package first;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("89654562311", "Samsung", 150.0);
        Phone phone2 = new Phone("89115639800", "Lenovo");
        Phone phone3 = new Phone();

        phone1.receiveCall("Евгения");
        phone2.receiveCall("Андрей", "89467761223");

        System.out.println(phone1.getNumber());
        System.out.println(phone2.getNumber());

        String[] phoneNumbers = {"89546784456", "89345643745", "89233341818", "89734584432"};
        phone3.sendMessage(phoneNumbers);

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
    }
}
