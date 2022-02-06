import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Date;

public class Sightings {
private  int id;
private int location_id;
private int ranger_id;
private  int  animal_id;
private Timestamp time;

    public Sightings(int location_id, int ranger_id, int  animal_id) {
   this.location_id = location_id;
   this.ranger_id = ranger_id;
   this.animal_id = animal_id;
   this.time = new Timestamp(new Date().getTime());
    }

    public static Sightings find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM sightings WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Sightings.class);

        }
    }

    public static void deleteAll(){
        try (Connection con=DB.sql2o.open()){
            String sql="DELETE FROM sightings";
            con.createQuery(sql)
                    .executeUpdate();
        }

    }


    public int getId() {
        return id;
    }


    public int getLocation_id() {
        return location_id;
    }

    public int getRanger_Id() {
        return ranger_id;
    }

    public int getAnimal_Id() {
        return  animal_id;
    }
    public Timestamp getTime() {
        return time;
    }
    public void save(){

        if(this.animal_id==-1||this.location_id==-1||this.ranger_id==-1){
            throw new IllegalArgumentException("All fields must be filled");
        }
        try (Connection conn=DB.sql2o.open()){
            String sql= "INSERT INTO sightings (animal_id,ranger_id,location_id,time) VALUES (:animal_id,:ranger_id," +
                    ":location_id,:time)";
            String joinRanger="INSERT INTO rangers_sightings (ranger_id,sighting_id) VALUES (:ranger_id,:sighting_id)";
            String joinLocation="INSERT INTO locations_sightings (location_id,sighting_id) VALUES (:location_id," +
                    ":sighting_id)";
            this.id=(int) conn.createQuery(sql,true)
                    .addParameter("animal_id",this.animal_id)
                    .addParameter("ranger_id",this.ranger_id)
                    .addParameter("location_id",this.location_id)
                    .addParameter("time",this.time)
                    .executeUpdate()
                    .getKey();
            conn.createQuery(joinRanger).addParameter("ranger_id",this.getRanger_Id()).addParameter("sighting_id",
                    this.getId()).executeUpdate();
            conn.createQuery(joinLocation).addParameter("location_id",this.getLocation_id()).addParameter("sighting_id",
                    this.id).executeUpdate();

        }

    }

    public void delete(){
        try (Connection con=DB.sql2o.open()){
            String sql="DELETE FROM sightings WHERE id=:id";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .executeUpdate();
        }

    }
    
}

