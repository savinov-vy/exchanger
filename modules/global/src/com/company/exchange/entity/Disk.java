package com.company.exchange.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @JoinTable(name = "EXCHANGE_DISK_GENRE_LINK",
            joinColumns = @JoinColumn(name = "DISK_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    @OnDeleteInverse(DeletePolicy.UNLINK)
    private List<Genre> genres;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "disk", optional = false)
    private TakenItem takenItem;

    public TakenItem getTakenItem() {
        return takenItem;
    }

    public void setTakenItem(TakenItem takenItem) {
        this.takenItem = takenItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}