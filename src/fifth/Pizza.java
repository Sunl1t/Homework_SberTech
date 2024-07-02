package fifth;

public class Pizza
{
    private String name;
    public enum Size
    {
        SMALL,
        MEDIUM,
        BIG
    }
    private boolean sauce;
    private Size size;
    private String address;
    private boolean isOrderAccepted;

    public Pizza(String name, Size size, boolean sauce, String address) {
        this.name = name;
        this.size = size;
        this.sauce = sauce;
        this.address = address;
    }

    public void order() {
        if (isOrderAccepted) {
            System.out.println("Заказ уже принят.");
        } else {
            isOrderAccepted = true;
            System.out.println("Заказ принят. " + size + " пицца «" + name + "»" +
                    (sauce ? " с соусом" : "") + " на адрес " + address + ".");
        }
    }

    public void cancel() {
        if (isOrderAccepted) {
            isOrderAccepted = false;
            System.out.println("Заказ отменен.");
        } else {
            System.out.println("Заказ не был принят.");
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isSauce() {
        return sauce;
    }
    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return ("Пицца " + name + "; Размер: " + size + "; С добавлением соуса: " + sauce + "; Адрес: " + address +
                '\'' + "; Статус заказа:" + isOrderAccepted);
    }
}


