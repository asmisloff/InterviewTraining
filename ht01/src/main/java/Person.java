import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    private Person() {
        firstName = "";
        lastName = "";
        middleName = "";
        country = "";
        address = "";
        phone = "";
        age = 0;
        gender = "";
    }

    public static Person createInstance() {
        return new Person();
    }

    public Person withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Person withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Person withCountry(String country) {
        this.country = country;
        return this;
    }

    public Person withAddress(String address) {
        this.address = address;
        return this;
    }

    public Person withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Person withAge(int age) {
        this.age = age;
        return this;
    }

    public Person withGender(String gender) {
        this.gender = gender;
        return this;
    }



}
