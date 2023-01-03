package springBoot3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;
    private Integer userid;

    public Customer() {
    }

    public Customer(Integer id, String title, String body, Integer userid) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userid = userid;
    }

    public Customer(String title, String body, Integer userid) {
        this.title = title;
        this.body = body;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(title, customer.title) && Objects.equals(body, customer.body) && Objects.equals(userid, customer.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, userid);
    }
}
