package com.javaee.generics.mod2;

/**
 * Created by Den on 24.08.2016.
 */
public class PersonTask implements Task<Person> {

   private Person person;

    public PersonTask(Person person){
        this.person = person;
    }

    @Override
    public void execute() {
        new PersonValidator().isValid(person);
    }

    @Override
    public Person getResult() {
        return person;
    }
}
