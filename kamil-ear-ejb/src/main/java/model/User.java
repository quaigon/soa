package model;

import javax.persistence.*;

/**
 * Created by Kamil on 05.06.2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "userQuery", query = "SELECT u FROM User u WHERE u.name LIKE :name"),
        @NamedQuery(name = "userByRole", query = "SELECT u FROM User u WHERE u.role LIKE :role")}
)
@Table(name = "users")
public class User {

    private String password;

    @Id
    @Column(unique = true)
    private String name;

    private String role;

    public User() {
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

    @Override
    public String toString() {
        return name;
    }
}
