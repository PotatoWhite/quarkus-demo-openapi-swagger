package me.potato.demo.expose;

import me.potato.demo.model.Fruit;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/fruits")
public class FruitResource {
  private Set<Fruit> fruits=Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

  public FruitResource(){
    fruits.add(new Fruit("Apple", "Winter fruit"));
    fruits.add(new Fruit("Pineapple", "Tropical fruit"));
  }

  @GET
  public Set<Fruit> all(){
    return fruits;
  }

  @POST
  public Set<Fruit> addAFruit(Fruit aFruit){
    fruits.add(aFruit);
    return all();
  }

  @DELETE
  public Set<Fruit> deleteAFruit(Fruit aFruit){
    fruits.removeIf(existing -> existing.getName()
                                        .equalsIgnoreCase(aFruit.getName()));
    return all();
  }
}
