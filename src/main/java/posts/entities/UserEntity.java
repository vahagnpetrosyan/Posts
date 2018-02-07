package posts.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;

    @Column(name = "FIRST_NAME", nullable = false)
    @NotNull
    @Size(min=2, max=30, message="{firstName.size}")
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    @NotNull
    @Size(min=2, max=30, message="{lastName.size}")
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    @NotNull
    @Email(message = "{email.valid}")
    private String email;

    public UserEntity() {}

    public UserEntity(String username, String password, String firstName, String lastName, String email) {
        this(null, username, password, firstName, lastName, email);
    }

    public UserEntity(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that,
                "firstName", "lastName", "username", "password", "email");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,
                "firstName", "lastName", "username", "password", "email");
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
