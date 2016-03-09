package ua.shykun.delivery.domain;



import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_customer", referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name = "user_login", unique = true)
    private String login;

    @Column(name = "user_password")
    private String password;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    Set<UserRole> userRoles;

    public User() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
