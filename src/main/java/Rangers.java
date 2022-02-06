import org.sql2o.Connection;

import java.util.List;

public class Rangers {
    private String name;
    private String badge_number;
    private  String phone_number;
    private int id;

    public Rangers(String name, String badge_number, String phone_number) {
        this.name = name;
        this.badge_number=  badge_number;
        this.phone_number= phone_number;
    }

    public static Rangers find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM rangers WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Rangers.class);
        }

    }


    public String getNane() {
        return name;
    }
    public String getBadgeNumber() {
      return badge_number;
    }

    public String getPhoneNumber() {
        return phone_number;
    }
    public int getId(){
        return id;
    }

    public void save() {
        try(Connection conn = DB.sql2o.open()) {
            String sql = "INSERT INTO rangers (name,badge_number,phone_number)VALUES(:name,:badge_number,:phone_number";
            if(name.equals("")||badge_number.equals("")||phone_number.equals("")){
                throw new IllegalArgumentException("All fields must be filled");
            }
            this.id=(int) conn.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("badge_number",this.badge_number)
                    .addParameter("phone_number",this.phone_number)
                    .executeUpdate()
                    .getKey();
        }
    }


    public static List<Rangers> all(){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM rangers";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Rangers.class);

        }

    }

    public void delete(){
        try (Connection con=DB.sql2o.open()){
            String sql="DELETE FROM rangers WHERE id=:id";

            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }
    }
}
