import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Animals {
public String name;
public String  type;
public String age;
public String health;
public int id;
public static final String CATEGORY= "not endangered";
    public Animals(String name, String age, String health) {
        this.name = name;
        this.type = CATEGORY;
        this.age = age;
        this.health =health;
    }




    public static List<Animals> all() {
        try(Connection conn = DB.sql2o.open()){
            String sql ="SELECT * FROM animals";
            return conn.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class);
        }
    }

    public static void deleteAll(){
        try (Connection con=DB.sql2o.open()){
            String sql = "DELETE FROM animals";
            con.createQuery(sql)
                    .executeUpdate();
        }  catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    public String getName() {
        return  name;
    }



    public String getType() {
        return type;
    }

    public void save() {
        if (this.name.equals("")||this.age.equals("")||this.health.equals("")){
            throw new IllegalArgumentException("Fields are required");
        }
        try(Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO  animals(name,age,health)VALUES(:name ,:age,:health)";
            this.id =(int) conn.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("age",this.age)
                    .addParameter("health",this.health)
                    .executeUpdate()
                    .getKey();
        }
        }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public int getId() {
        return id;
    }
    public static Animals find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql= "SELECT * FROM animals WHERE id=:id";
            Animals animal=  con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animals.class);
            return animal;

        }

    }
    public void delete(){
        try (Connection con=DB.sql2o.open()){
            String sql = "DELETE FROM animals WHERE id=:id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }

}

