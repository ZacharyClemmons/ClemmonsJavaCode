import java.util.Scanner;

public class ObjectClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//fname,lname,superpower,age,powerlevel
        Superhero hero1 = new Superhero("Bob", "Tomson", "Flying", 25, 10);
        Superhero hero2 = new Superhero("Bill", "Joey", true);
        Superhero hero3 = new Superhero("John", "Ji", "Superstrength", 44, 8);
        String heroString = hero1.toString();
        System.out.println(heroString);
        System.out.println(hero1.equals(hero2));
        System.out.println(hero1.strengthLevel);
        System.out.println(hero1.hashCode());
        hero1.attack();
        hero2.retired();
        hero3.superpower();
    }}