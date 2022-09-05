package com.company.exchange.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "EXCHANGE_DISK")
@Entity(name = "exchange_Disk")
@NamePattern("%s|name")
public class Disk extends StandardEntity {
    private static final long serialVersionUID = 8306852341735930863L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @JoinTable(name = "EXCHANGE_DISK_GENRE_LINK",
            joinColumns = @JoinColumn(name = "DISK_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    @OnDeleteInverse(DeletePolicy.UNLINK)
    private List<Genre> genre;

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}