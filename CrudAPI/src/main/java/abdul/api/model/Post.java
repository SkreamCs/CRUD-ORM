package abdul.api.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;
    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostStatus postStatus;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "post_labels",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "label_id", referencedColumnName = "id")

    )
    private List<Label> labels;

    public Post() {
    }

    public Post(String content, Date created, Date updated, List<Label> labels) {
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", labels=" + labels +
                ", postStatus=" + postStatus +
                '}';
    }
}
