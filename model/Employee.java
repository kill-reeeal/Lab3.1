package model;

final public class Employee extends AbstractPerson {
    String department;
    int age;
    String phone;
    String position;
    String gender;

    public Employee(String name, String department, int age, String phone,String position , String gender){
        super (name);
        this.department = department;
        this.age = age;
        this.position = position;
        this.phone = phone;
        this.gender = gender;
    }

    public String gerDepartment(){return department;}

    public int getAge(){return age;}

    public String getPhone(){return phone;}

    public String getPosition(){return position;}

    public String getGender(){return gender;}

    @Override
    public String think(){return "I'm a employee";}
}