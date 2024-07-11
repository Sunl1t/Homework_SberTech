public class FirstClass
{
    private SecondClass second;

    public FirstClass(SecondClass second) {
        this.second =  second;
    }
    
    public String firstToSecond()
    {
        return "Kenobi!!";
    }

    private String privateMethod()
    {
        return "Hello There";
    }

}
