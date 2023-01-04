package com.company.exchange.helpers;

import com.haulmont.cuba.core.global.UserSessionSource;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

@Component
public class DateHelper {
    @Inject
    protected UserSessionSource userSessionSource;

    public Pair<Date, Date> getDateMonthRange(Date date) {
        Date start, end;

        {
            Calendar calendar = getCalendarForNow(date);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            setTimeToBeginningOfDay(calendar);
            start = calendar.getTime();
        }

        {
            Calendar calendar = getCalendarForNow(date);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            setTimeToEndofDay(calendar);
            end = calendar.getTime();
        }

        return Pair.of(start, end);
    }

    public Pair<Date, Date> getDateWeekRange(Date date) {
        Locale locale = userSessionSource.getUserSession().getLocale();
        LocalDate localDate = toLocalDate(date);

        LocalDateTime start = localDate.with(WeekFields.of(locale).dayOfWeek(), 1L).atStartOfDay();
        LocalDateTime end = localDate.with(WeekFields.of(locale).dayOfWeek(), 7L).atStartOfDay().plusDays(1).minusNanos(1);

        return Pair.of(toDate(start), toDate(end));
    }

    public LocalDate toLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public Date toDate(LocalDateTime ldt) {
        return toDate(ldt, ZoneId.systemDefault());
    }

    public Date toDate(LocalDateTime ldt, ZoneId zoneId) {
        return Date.from(ldt.atZone(zoneId).toInstant());
    }

    public Calendar getCalendarForNow(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public void setTimeToBeginningOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public void setTimeToEndofDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }
}