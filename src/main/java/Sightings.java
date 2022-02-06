import org.sql2o.Connection;

public class Sightings {
private  int id;
private int location_id;
private int ranger_id;
private  int  animal_id;

    public Sightings(int location_id, int ranger_id, int  animal_id) {
   this.location_id = location_id;
   this.ranger_id = ranger_id;
   this.animal_id = animal_id;
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

    public void save(){

        if(this.animal_id==-1||this.location_id==-1||this.ranger_id==-1){
            throw new IllegalArgumentException("All fields must be filled");
        }
        try (Connection conn=DB.sql2o.open()){
            String sql= "INSERT INTO sightings (animal_id,ranger_id,location_id,time) VALUES (:animal_id,:ranger_id," +
                    ":location_id,:time)";
        }
}
