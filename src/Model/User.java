package Model;

/**
 * The User class.
 * Full of variables, which a User contains.
 *
 * @author Oscar
 * @since 19-11-2015
 *
 * Created by Oscar on 19-11-2015.
 */
public class User {

    /** The id. */
    private long id;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The email. */
    private String email;
    
    /** The username. */
    private String username;
    
    /** The password. */
    private String password;
    
    /** The status. */
    private String status;
    
    /** The type. */
    private int type;
    
    /** The created. */
    private String created;

    /**
     * Creates the constructor.
     */
    public User(){}

    /**
     * Gets the type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the first_name.
     *
     * @return the first_name
     */
    public String getFirst_name() {
        return firstName;
    }

    /**
     * Sets the first_name.
     *
     * @param first_name the new first_name
     */
    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    /**
     * Gets the last_name.
     *
     * @return the last_name
     */
    public String getLast_name() {
        return lastName;
    }

    /**
     * Sets the last_name.
     *
     * @param last_name the new last_name
     */
    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the created.
     *
     * @param created the new created
     */
    public void setCreated(String created){
        this.created = created;
    }

    /**
     * Gets the created.
     *
     * @return the created
     */
    public String getCreated(){
        return created;
    }
}
