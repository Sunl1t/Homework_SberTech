package Sunlit.lambda;

import lombok.Getter;
import lombok.Setter;

public class Cow implements Sounding {

    @Override
    public void sound()
    {
        System.out.println("Moo");
    }

    @Setter
    @Getter
    public static class Resource {
        public int value;

        public Resource(int value) {
            this.value = value;
        }
    }

    public static class ResourceProcessor {

        public void increase(Resource r) {
            System.out.println(r.value+=1);
        }

        public void decrease(Resource r) {
            System.out.println(r.value-=1);
        }
    }
}
