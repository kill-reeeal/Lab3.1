import model.HumanInterface;

public abstract class AbstractPerson implements HumanInterface {
    private String name;

    AbstractPerson(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract String think(); //abstract method
}
