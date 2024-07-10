/*
The constructor call itself we get recursive constructor invocation error.
*/
class ConstructorChaining {
    String name;
    int Id;
    String gender;

    ConstructorChaining() {
        this("Yogesh", 9);
        System.out.println("Zero Param Constructor");
    }

    ConstructorChaining(String name) {
        this("Siva", 99);
        System.out.println("Single param Constructor");
    }

    ConstructorChaining(String name, int id ) {
        this("babu", "Male");
        this.name = name;
        this.Id = id;
        System.out.println("Two Param Constructor");
    }

    ConstructorChaining(String name, String gender ) {
        this.name = name;
        this.gender = gender;
        System.out.println("Param Constructor");
    }

    public static void main(String [] args) {
        System.out.println("Welcome to constructor chaining");
        ConstructorChaining constructorChaining = new ConstructorChaining();
        System.out.println("Print the 1st excicution" + constructorChaining);
        ConstructorChaining constructorChaining1 = new ConstructorChaining("Yoga");
        System.out.println("Print the 2nd excicution" + constructorChaining1);
        ConstructorChaining constructorChaining2 = new ConstructorChaining("dhana", 8 );
        System.out.println("Print the 3rd excicution" + constructorChaining1);
    }

    @Override
    public String toString() {
      return "name " + name + "id " + Id + "Gender " + gender;
    }

}
