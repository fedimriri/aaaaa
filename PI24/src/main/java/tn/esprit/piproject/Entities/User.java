package tn.esprit.piproject.Entities;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
public class User {

    private int id;
    private static int idCounter = 0;
    public User() {

        this.id = ++idCounter;
    }
    private String name;
    private String lastName;
    private String email;
    private Role role;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public Role getADMIN() { return role;}
    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
