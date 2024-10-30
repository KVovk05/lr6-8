package bank;

public class Bank {
    private String name;
    public Bank(String name) {
        this.name = name;
    }
    public Bank(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                '}';
    }
}
