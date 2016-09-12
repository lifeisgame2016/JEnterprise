package javaee.generics.mod2;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExecutorImplTest {


@Test
    public void withoutExceptionTest() throws ExecutorException {
        Executor<Person> personExecutor = new ExecutorImpl<>();

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Garik", "Torin"),
                new Person("Tixon", ""),
                new Employee("Denis", "Rigon", "Developer"),
                new Employee("Tatia", "", "Engineer")
        ));

        for(Person person : persons){
            personExecutor.addTask(new PersonTask(person), new PersonValidator());
        }

        personExecutor.execute();

        System.out.println("Valid results: ");
        List<Person> validResults = personExecutor.getValidResults();
        validResults.forEach(System.out::println);

        System.out.println("Invalid result: ");
        List<Person> invalidResults = personExecutor.getInvalidResults();
        invalidResults.forEach(System.out::println);

        assertEquals(2, validResults.size());
        assertEquals(2, invalidResults.size());
    }



}