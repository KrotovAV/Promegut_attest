package Lottory_toys;

public class Toy {
    int toyID;
    String name;
    int available;
    double frequency;

    Toy() {
    }
    
    Toy(int tempToyID, String tempName, int tempAvailable, double tempFrequency) {
        toyID = tempToyID;
        name = tempName;
        available = tempAvailable;
        frequency = tempFrequency;

        Write.writeFile("Toy: " + String.valueOf(toyID) + ":" 
        + String.valueOf(name) + " (" 
        + String.valueOf(available) + " Units, " 
        + String.valueOf(frequency) +  " freq)");
    }

    public int getToyID() {
        return toyID;
    }
    public void setToyID(int toyID) {
        this.toyID = toyID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable() {
        return available;
    }
    public void setAvailable(int available) {
        this.available = available;
    }

    public double getFrequency() {
        return frequency;
    }
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    public void modifyFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void print() {
        Write.writeFile("Print Toy: " + String.valueOf(toyID) + ":" 
                        + String.valueOf(name) + " (" 
                        + String.valueOf(available) + " Units, " 
                        + String.valueOf(frequency) +  " freq)");

        System.out.println("Toy: "
                           + "id"+ toyID + ": " 
                           + name + " (" 
                           + available + " Units, " 
                           + frequency +  " freq);" );
    }

 

    // public void buttonClick(){
    //     int a = view.getValue("a: ");
    //     int b = view.getValue("b: ");
    //     model.setX(a);
    //     model.setY(b);
    //     int result = model.result();
    //     view.print(result, "Sum: ");
    // }
}
