package bay.spring.MVC.dao;

import bay.spring.MVC.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_ID;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_ID, "Igor"));
        people.add(new Person(++PEOPLE_ID, "Nastya"));
        people.add(new Person(++PEOPLE_ID, "Bob"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void create(Person person){
        person.setId(++PEOPLE_ID);
        people.add(person);
    }
}
