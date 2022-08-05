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

