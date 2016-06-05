package model;

import javax.persistence.*;

/**
 * Created by Kamil on 05.06.2016.
 */

@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private String password;
    @Column(unique = true)
    private String name;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
