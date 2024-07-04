package first;

public class Phone {
    private double weight;
    private String number;
    private String model;
    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(){};

    public void receiveCall(String name)
    {
        System.out.println("Звонит" + name);
    }
    
    public String getNumber()
    {
        return number;
    }

    public void receiveCall(String callNumber, String name)
    {
        System.out.println("Звонит " + name + " номер телефона: " + callNumber);
    }

    public void sendMessage(String[] phoneNumbers){
        System.out.println("Отправка сообщений на номера: ");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }

    @Override
    public String toString()
    {
        return number + " " + model + " " + weight;
    }
}

