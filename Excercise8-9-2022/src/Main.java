public class Main {
    public static void main(String[] args) {

        Animal dog = new Animal();
        Animal cat= new Animal();
        Car civic = new Car("Red", 6, 4, 500);

        civic.getWeight();
        civic.setWheels(5);
        civic.setColor("Brown");
        //overloaded
        civic.setColor("Orange", "Red");
        System.out.println(civic.getWheels());
        System.out.println(civic.getColors());
        civic.printer();
    }
}
