import java.sql.SQLOutput;

public class Superhero {
    //declare variables
    String firstName;
    String lastName;
    String superPower;
    int age;
    int strengthLevel;
    boolean retired;

    //age minus strengthLevel

    public Superhero(String firstName, String lastName, String superPower,int age, int strengthLevel)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.superPower=superPower;
        this.age=age;
        this.strengthLevel=strengthLevel;

    }
    public Superhero(String firstName, String lastName,boolean retired)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.retired=retired;

    }
    public void attack()
    {
        System.out.println(firstName+"  attack power is  "+strengthLevel);
    }
    public void retired() {
        if ( retired = true){
            System.out.println(retired + "" + firstName + "  is retired");
        }
        else
        {
            System.out.println(firstName + "Is not retired");
        }
    }
    public void superpower()
    {
        System.out.println("The superpower for "+ firstName+ " is "+ superPower);
    }

    //override
    @Override
    public String toString(){
        //initialize return value to empty string
        String returnValue ="";
        returnValue+= "Superhero information ->";
        returnValue+="First name"+this.firstName;
        returnValue+="Lastname"+this.lastName;
        returnValue+="superpower"+this.superPower;
        returnValue+="age"+this.age;
        return returnValue;
    }
}

