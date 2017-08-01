package org.github.stream.model;

/**
 * Created by vlevash on 7/27/17.
 */
public class LoginVM {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LoginVM{" +
                "name='" + name + '\'' +
                '}';
    }
}
