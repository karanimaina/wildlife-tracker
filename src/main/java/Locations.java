import org.sql2o.Connection;

import java.util.List;

public class Locations {
private String name;
private  int id;
    public Locations(String name) {
        this.name = name;
    }

    public static List<Locations> all(){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM locations";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Locations.class);
        }
    }

    public String getName() {
        return  name;
    }
    public int getId(){
        return id;
    }

    public void save() {
        try(Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO locations(name)VALUES(:values)";
            if (name.equals("")){
                throw new IllegalArgumentException("required fields");
        }
       this .id = (int)conn.createQuery(sql,true)
               .addParameter("name",this.name)
               .executeUpdate()
               .getKey();
    }
}


}
