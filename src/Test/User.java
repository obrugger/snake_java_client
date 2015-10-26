package Test;

import java.util.Date;

/**
 * Created by Oscar on 26-10-2015.
 */
public class User {

    private int id =1 ;
    private String first_name = "oscar";
    private String last_name = "brugger";
    private String email = "obrugger@gmail.com";
    private String username = "obrugger";
    private String password = "1234";
    private Date created = null;
    private String status = null;
    private String type = null;

    public User(){

    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreated() {
        return created;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }
}
