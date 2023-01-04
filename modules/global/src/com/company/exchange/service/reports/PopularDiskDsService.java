package com.company.exchange.service.reports;

import com.company.exchange.dto.PopularDiskDsDto;

import java.util.Date;
import java.util.List;

public interface PopularDiskDsService {
    String NAME = "exchange_PopularDiskDsService";

    List<PopularDiskDsDto> getActivityReportDtoList(Date fromTs, Date toTs);
}