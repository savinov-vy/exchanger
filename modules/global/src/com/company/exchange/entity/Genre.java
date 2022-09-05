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

@Table(name = "EXCHANGE_GENRE")
@Entity(name = "exchange_Genre")
@NamePattern("%s|name")
public class Genre extends StandardEntity {
    private static final long serialVersionUID = 814336271246669741L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @JoinTable(name = "EXCHANGE_DISK_GENRE_LINK",
            joinColumns = @JoinColumn(name = "GENRE_ID"),
            inverseJoinColumns = @JoinColumn(name = "DISK_ID"))
    @ManyToMany
    @OnDelete(DeletePolicy.UNLINK)
    @OnDeleteInverse(DeletePolicy.UNLINK)
    private List<Disk> disk;

    public List<Disk> getDisk() {
        return disk;
    }

    public void setDisk(List<Disk> disk) {
        this.disk = disk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}