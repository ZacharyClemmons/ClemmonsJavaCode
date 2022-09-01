package entity;

public class Ticket {

    private int id;
    int owner_id;
    private String name;
    private boolean status;
    private boolean processed;
    private String description;
    private int amount;

    public Ticket()
    {

    }
    public Ticket (String description, boolean status, boolean processed, int id)
    {

        this.description=description;
        this.status=status;
        this.processed=processed;
        this.id=id;

    }
public Ticket (int id,int owner_id ,String name,int amount, String description , boolean status)
{

}
    public Ticket(int id, int owner_id, int amount, String description, boolean status)
    {

    }


    public Ticket(int owner_id, String name, int amount, String description, boolean status) {
        this.name = name;
        this.status = status;
        this.owner_id=owner_id;
        this.description = description;
        this.amount=amount;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount() {this.amount=amount;}

    public int getAmount(){return amount;}


    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public boolean getProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
