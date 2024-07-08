package Sunlit.unit_tests;

public class SecondClass
{
    private final FirstClass first;

    public SecondClass(FirstClass first) {
        this.first = first;
    }

    public String secondToFirst()
    {
        return "General Kenobi!";
    }

    public void methodThrowingException()
    {
        throw new UnsupportedOperationException("Exception");
    }
}
