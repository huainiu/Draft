package EffectiveJavaNotes;

/*
 * Created by Michael.Shreiber on 12/16/13.
 * The Builder pattern combines the safety of the telescoping constructor pattern with the
 * readability of the JavaBeans pattern. It is a form of the
 * Builder pattern [Gamma95, p. 97]. Instead of making the desired object directly,
 * the client calls a constructor (or static factory) with all of the required parameters
 * and gets a builder object. Then the client calls setter-like methods on the builder
 * object to set each optional parameter of interest. Finally, the client calls a parameterless
 * build method to generate the object, which is immutable. The builder is a
 * static member class (Item 22) of the class it builds.
 *
 * In summary, the Builder pattern is a good choice when designing classes
 * whose constructors or static factories would have more than a handful of
 * parameters, especially if most of those parameters are optional. Client code is
 * much easier to read and write with builders than with the traditional telescoping
 * constructor pattern, and builders are much safer than JavaBeans.
 *
 * Here’s how it looks in practice:
 */

// Builder Pattern
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString(){
        return "[" + servingSize + ", " + servings + ", " + calories + ", " + fat + ", " + sodium + ", " + carbohydrate + "]";
    }

    public static void main(String[] args) {

        //Note that NutritionFacts is immutable, and that all parameter default values
        //are in a single location. The builder’s setter methods return the builder itself so
        //that invocations can be chained. Here’s how the client code looks:
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).
                calories(100).sodium(35).carbohydrate(27).build();

        System.out.println(cocaCola);
    }
}
