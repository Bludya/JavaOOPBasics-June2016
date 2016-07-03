package Problem03_Mankind;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public abstract class Human {
    private String firstName;
    private String lastName;

    protected Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if(firstName.charAt(0) < 'A' || firstName.charAt(0) > 'Z'){
            throw new IllegalArgumentException(Exceptions.FIRST_NAME_CAPITAL_LETTER);
        }
        if(firstName.length() < 4){
            throw new IllegalArgumentException(Exceptions.FIRST_NAME_LENGTH);
        }
        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {

        if(lastName.charAt(0) < 'A' || lastName.charAt(0) > 'Z'){
            throw new IllegalArgumentException(Exceptions.LAST_NAME_CAPITAL_LETTER);
        }

        if(lastName.length() < 3){
            throw new IllegalArgumentException(Exceptions.LAST_NAME_LENGTH);
        }


        this.lastName = lastName;
    }
}
