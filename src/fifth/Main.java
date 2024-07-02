package fifth;

public class Main {
    public static void main(String[] args) {
        Pizza order = new Pizza("Аль-Капчоне", Pizza.Size.BIG, true, "Ярославская 101");

        order.order();
        order.order();  // Попытка повторного заказа
        order.cancel();
        order.cancel();  // Попытка отмены уже отмененного заказа

        System.out.println(order);
    }
}
