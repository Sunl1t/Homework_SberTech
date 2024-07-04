public class SecondClass
{
    FirstClass first;

    public String secondToFirst()
    {
        return "General "+ first.firstToSecond();
    }

    public void methodThrowingException()
    {
        throw new UnsupportedOperationException("Exception");
    }

}
