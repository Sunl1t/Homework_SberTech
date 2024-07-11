package Sunlit.lambda;
import java.util.ArrayList;
import java.util.List;


public class LambdaMain {
     public void testSound() {
        List<Sounding> soundings = new ArrayList<>();

        soundings.add(new Cat());
        soundings.add(new Octopus());
        soundings.add(new Mouse());
        soundings.add(new Dog());
        soundings.add(new Cow());

        for (Sounding sounding : soundings) {
            sounding.sound();
        }

        soundings.add(new Sounding() {
            @Override
            public void sound() {
                System.out.println("V for Vendetta");
            }
        });

        soundings.add(() -> System.out.println("Lambda"));

        for (Sounding sounding : soundings) {
            sounding.sound();
        }

        NonSounding nonSounding = new NonSounding();
        soundings.add(nonSounding::instanceSound);
        soundings.add(NonSounding::staticSound);

        for (Sounding sounding : soundings) {
            sounding.sound();
        }

        soundings.forEach(Sounding::sound);
    }
}
