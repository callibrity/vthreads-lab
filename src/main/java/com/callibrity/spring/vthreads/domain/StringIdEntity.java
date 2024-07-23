package com.callibrity.spring.vthreads.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;

import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class StringIdEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    protected StringIdEntity(String id) {
        this.id = id;
    }

    protected StringIdEntity() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringIdEntity that)) return false;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
