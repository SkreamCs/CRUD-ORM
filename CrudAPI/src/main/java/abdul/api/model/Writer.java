package abdul.api.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "writers")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "writer_id")
    private List<Post> posts;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Writer() {
    }

    public Writer(String firstName, String lastName, List<Post> posts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", posts=" + posts +
                ", status=" + status +
                '}';
    }
}
