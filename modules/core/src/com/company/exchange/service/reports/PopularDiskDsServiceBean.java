package com.company.exchange.service.reports;

import com.company.exchange.constant.AppConstants;
import com.company.exchange.dto.PopularDiskDsDto;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(PopularDiskDsService.NAME)
public class PopularDiskDsServiceBean implements PopularDiskDsService {
    @Inject
    private Metadata metadata;
    @Inject
    private Persistence persistence;

    @Override
    public List<PopularDiskDsDto> getActivityReportDtoList(Date fromTs, Date toTs) {
        return takenItemsByPeriod(fromTs, toTs);
    }

    public List<PopularDiskDsDto> takenItemsByPeriod(Date fromTs, Date toTs) {
        return persistence.createTransaction().execute(em -> {
            Query query = em.createNativeQuery("select d.name, count(d) from exchange_taken_item as ti " +
                    "join exchange_disk as d on ti.disk_id = d.id " +
                    "join sec_user as u on ti.user_id = u.id " +
                    "where ti.delete_ts > #fromTs and ti.delete_ts <= #toTs " +
                    "and u.group_names = #groupName " +
                    "group by d.name " +
                    "order by count(d) desc limit 3");
            query.setParameter("fromTs", fromTs);
            query.setParameter("toTs", toTs);
            query.setParameter("groupName", AppConstants.MANAGER_GROUP);
            return resultsToActivityReportDtoList(query.getResultList());
        });
    }

    private List<PopularDiskDsDto> resultsToActivityReportDtoList(List<?> resultList) {
        List<PopularDiskDsDto> popularDiskDsReportLinesDto = new ArrayList<>();
        for (Object obj : resultList) {
            PopularDiskDsDto popularDiskDsLineDto = metadata.create(PopularDiskDsDto.class);
            Object[] row = (Object[]) obj;
            popularDiskDsLineDto.setPopularDiskName((String) row[0]);
            popularDiskDsLineDto.setCountRent((Long) row[1]);
            popularDiskDsReportLinesDto.add(popularDiskDsLineDto);
        }
        return popularDiskDsReportLinesDto;
    }
}