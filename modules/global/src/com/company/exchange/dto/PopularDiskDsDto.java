package com.company.exchange.dto;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.BaseUuidEntity;

@MetaClass(name = "exchange_ActivityReportDto")
public class PopularDiskDsDto extends BaseUuidEntity {
    private static final long serialVersionUID = 1849281163212939582L;

    @MetaProperty
    private String popularDiskName;

    @MetaProperty
    private Long countRent;

    public String getPopularDiskName() {
        return popularDiskName;
    }

    public void setPopularDiskName(String popularDiskName) {
        this.popularDiskName = popularDiskName;
    }

    public Long getCountRent() {
        return countRent;
    }

    public void setCountRent(Long countRent) {
        this.countRent = countRent;
    }
}