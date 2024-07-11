public class SecondClass
{
    private FirstClass first;

    public SecondClass(FirstClass first) {
        this.first = first;
    }
    
    public String secondToFirst()
    {
        return "General "+ first.firstToSecond();
    }

    public void methodThrowingException()
    {
        throw new UnsupportedOperationException("Exception");
    }

}
