package com.callibrity.spring.vthreads.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class StringIdEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant modifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;

    protected StringIdEntity(String id) {
        this.id = id;
    }

    protected StringIdEntity() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof StringIdEntity)) return false;

        StringIdEntity that = (StringIdEntity) o;

        return new EqualsBuilder().append(id, that.id).isEquals();
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).toHashCode();
    }


}