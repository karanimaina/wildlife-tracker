import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "karani-dev", "felixmaina");
   //public static Sql2o sql2o = new Sql2o("jdbc:postgresql//rrwatsudlmzmns:90a7068a7c482a99d00b6e8db2264c4aa46ab449bd3a1f5ca1d15af8e2063710@ec2-23-20-73-25.compute-1.amazonaws.com:5432/d14crtveecinsd", "rrwatsudlmzmns", "90a7068a7c482a99d00b6e8db2264c4aa46ab449bd3a1f5ca1d15af8e2063710");

}