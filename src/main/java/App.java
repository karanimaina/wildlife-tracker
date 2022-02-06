import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        //welcome page
        get("/",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"welcome.hbs");
        },new HandlebarsTemplateEngine());
     //getting the ranger form
        get("/create/ranger",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"ranger-form.hbs");
        },new HandlebarsTemplateEngine());
        //create a new ranger object
        post("/create/ranger/new",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            String name=request.queryParams("name");
            String badge_number=request.queryParams("badge");
            String phone_number=request.queryParams("phone");
            Rangers ranger=new Rangers(name,badge_number,phone_number);
            ranger.save();
            return new ModelAndView(model,"ranger-form.hbs");
        },new HandlebarsTemplateEngine());
//view ranger details
        get("/view/rangers",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("rangers",Rangers.all());
            return new ModelAndView(model,"ranger-view.hbs");
        },new HandlebarsTemplateEngine());

        get("/view/ranger/sightings/:id",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            int idOfRanger= Integer.parseInt(request.params(":id"));
            Rangers foundRanger=Rangers.find(idOfRanger);
            List<Sightings> sightings=foundRanger.getRangerSightings();
            List<String> animals=new ArrayList<>();
            List<String> types=new ArrayList<>();
            for (Sightings sighting : sightings){
                String animal_name=Animals.find(sighting.getAnimal_Id()).getName();
                String animal_type=Animals.find(sighting.getAnimal_Id()).getType();
                animals.add(animal_name);
                types.add(animal_type);
            }
            model.put("sightings",sightings);
            model.put("animals",animals);
            model.put("types",types);
            model.put("rangers",Rangers.all());
            return new ModelAndView(model,"ranger-view.hbs");
        },new HandlebarsTemplateEngine());
// create a location
        get("/create/location",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"location-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/create/location/new",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            String name=request.queryParams("name");
            Locations location=new Locations(name);
            try {
                location.save();
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }
            return new ModelAndView(model,"location-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/view/locations",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("locations",Locations.all());
            return new ModelAndView(model,"location-view.hbs");
        },new HandlebarsTemplateEngine());






















    }
}
