package model;

import javax.persistence.*;

/**
 * Created by Kamil on 10.09.2016.
 */
@Entity
@NamedQueries(
        @NamedQuery(name = "ingQuery", query = "SELECT i FROM Ingridient i WHERE i.name LIKE :name")
)
public class Ingridient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ingridientId;

    private String name;

    public Ingridient() {

    }

    public int getIngridientId() {
        return ingridientId;
    }

    public void setIngridientId(int ingridientId) {
        this.ingridientId = ingridientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingridient that = (Ingridient) o;

        if (ingridientId != that.ingridientId) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = ingridientId;
        result = 31 * result + name.hashCode();
        return result;
    }
}
