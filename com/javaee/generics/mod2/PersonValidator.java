package com.javaee.generics.mod2;

import org.apache.commons.lang3.StringUtils;

public class PersonValidator implements Validator<Person> {

    @Override
    public boolean isValid(Person result) {

        return StringUtils.isNotBlank(result.getName()) && StringUtils.isNotBlank(result.getSurname());
    }
}
