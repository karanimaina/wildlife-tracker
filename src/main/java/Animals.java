import java.util.List;

public class Animals {
public String name;
public String  type;
public static final String CATEGORY= "not endangered";
    public Animals(String name) {
        this.name = name;
        this.type = CATEGORY;
    }



    public String getName() {
        return  name;
    }



    public String getType() {
        return type;
    }
}
