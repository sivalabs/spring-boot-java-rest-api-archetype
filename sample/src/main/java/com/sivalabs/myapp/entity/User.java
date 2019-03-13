package com.sivalabs.myapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq")
    @GeneratedValue(generator = "user_id_generator")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void preSave() {
        if(createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    void preUpdate() {
        if(updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
    }
}
