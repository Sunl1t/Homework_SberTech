package sunlit.annotations;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;

@Target(ElementType.TYPE)
@Inherited

public @interface InheritanceAnnotation
{
    int dayOfWeek();
}
