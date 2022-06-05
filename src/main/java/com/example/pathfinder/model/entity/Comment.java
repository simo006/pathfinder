package com.example.pathfinder.model.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column
    private boolean approved;

    @Column
    private Instant created;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;

    @PrePersist
    private void setCreated() {
        if (this.created == null) {
            this.created = Instant.now();
        }
    }

    public boolean isApproved() {
        return approved;
    }

    public Comment setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Comment setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
