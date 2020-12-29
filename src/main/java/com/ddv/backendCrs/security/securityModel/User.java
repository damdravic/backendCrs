package com.ddv.backendCrs.security.securityModel;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long userId;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column ( name = "username")
    private String username;

    @Column (name = "password")
    private String password;

    @Column (name = "user_email")
    private String userEmail;

    @Column (name = "roles")
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
               joinColumns = @JoinColumn(name = "userId",referencedColumnName = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "roleId",referencedColumnName = "role_id"))
    private Collection<Role> rolesCollection;

    public User(Long userId, String firstName, String lastName, String username, String password, String userEmail, Collection<Role> rolesCollection) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userEmail = userEmail;
        this.rolesCollection = rolesCollection;
    }

    public User(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Collection<Role> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Role> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }
}
