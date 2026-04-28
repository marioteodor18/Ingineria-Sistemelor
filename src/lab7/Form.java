package lab7;

public class Form {
    private String color;


//7.6.1
    private static int counter = 0;

//7.6.1
    public Form() {
        color = "white";
        counter++;
    }
//7.6.1
    public Form(String color) {
        this.color = color;
        counter++;
    }

    public float getArea() {
        return 0;
    }
//7.6.1 metoda
    public static int getInstanceCount() {
        return counter;
    }


    public String toString() {
        return "This form has the color " + color;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Form) {
            Form f = (Form) obj;
            if (this.color == null && f.color == null) {
                return true;
            } else if (this.color != null && f.color != null && this.color.compareTo(f.color) == 0) {
                return true;
            }
        }
        return false;

    }




}
