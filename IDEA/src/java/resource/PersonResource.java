package resource;

import model.*;


import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;


@Path("person")
public class PersonResource {
    //@Inject
    @EJB
    private PersonDao personDao;

    @GET
    @Produces("application/json")
    public List<Person> all() {
        return personDao.getAll();
    }

//    @GET
//    @Produces("application/json")
//    public Person test(){
//        Person berend = new Person("Berend", "Baardse");
//        personDao.save(berend);
//        return berend;
//
//    }

    @POST
    @Produces("application/json")
    public void save(Person person) {
        personDao.save(person);
    }

    @PUT
    @Consumes("application/json")
    public void update(Person person) {
        personDao.update(person);
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    public void delete(@PathParam("id") Long id) {
        Person person = personDao.find(id);
        personDao.delete(person);
    }
}

