import org.sql2o.Connection;

import java.util.List;

public class Animals {
public String name;
public String  type;
public String age;
public String health;
public static final String CATEGORY= "not endangered";
    public Animals(String name) {
        this.name = name;
        this.type = CATEGORY;
        this.name ="";
        this.age = "";
        this.health ="";
    }



    public String getName() {
        return  name;
    }



    public String getType() {
        return type;
    }

    public void save() {
        if (this.name.equals("")||this.age.equals("")||this.health.equals("")||this.type.equals("")){
            throw new IllegalArgumentException("Fields are required");
        }

    }
}
