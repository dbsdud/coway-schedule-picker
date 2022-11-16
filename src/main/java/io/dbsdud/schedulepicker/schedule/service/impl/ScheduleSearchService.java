package io.dbsdud.schedulepicker.schedule.service.impl;

import com.querydsl.jpa.JPQLQuery;
import io.dbsdud.schedulepicker.coordinate.data.entity.QCoordinate;
import io.dbsdud.schedulepicker.customer.data.entity.QCustomer;
import io.dbsdud.schedulepicker.customer.data.entity.QHaveProduct;
import io.dbsdud.schedulepicker.product.data.entity.ProductType;
import io.dbsdud.schedulepicker.product.data.entity.QProduct;
import io.dbsdud.schedulepicker.schedule.data.dto.request.ScheduleSearchType;
import io.dbsdud.schedulepicker.schedule.data.entity.QSchedule;
import io.dbsdud.schedulepicker.schedule.data.entity.Schedule;
import io.dbsdud.schedulepicker.schedule.data.entity.ScheduleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class ScheduleSearchService extends QuerydslRepositorySupport {

    public ScheduleSearchService() {
        super(Schedule.class);
    }

    public Page<Schedule> search (
            final long coordinateId,
            final ScheduleSearchType searchType,
            final String value,
            final Integer year,
            final Integer month,
            final Integer day,
            final Integer hour,
            final Integer minute,
            final Pageable pageable
    ) {
        final QHaveProduct haveProduct = QHaveProduct.haveProduct;
//        final QMatchingSchedule matchingSchedule = QMatchingSchedule.matchingSchedule;
//        final QCustomer customer = QCustomer.customer;
//        final QProduct product = QProduct.product;
        final QSchedule schedule = QSchedule.schedule;

        final JPQLQuery<Schedule> query = switch (searchType) {
            case CUSTOMER_NAME -> from(schedule)
                    .leftJoin(schedule.haveProduct, haveProduct)
                    .where(haveProduct.customer.name.contains(value)
                            .and(schedule.coordinate.coordinateId.eq(coordinateId)));
//                    .leftJoin(schedule.customer, customer)
//                    .where(customer.name.contains(value));
            case CUSTOMER_ADDRESS -> from(schedule)
                    .leftJoin(schedule.haveProduct, haveProduct)
                    .where(haveProduct.customer.address.address1.contains(value)
                            .or(haveProduct.customer.address.address2.contains(value))
                            .and(schedule.coordinate.coordinateId.eq(coordinateId)));
//                    .leftJoin(schedule.customer, customer)
//                    .where(customer.address.address1.contains(value)
//                            .or(customer.address.address2.contains(value)));
            case CUSTOMER_TEL -> from(schedule)
                    .leftJoin(schedule.haveProduct, haveProduct)
                    .where(haveProduct.customer.tel.contains(value)
                            .and(schedule.coordinate.coordinateId.eq(coordinateId)));
//                    .leftJoin(schedule.customer, customer)
//                    .where(customer.tel.contains(value));
            case PRODUCT_TYPE -> from(schedule)
                    .leftJoin(schedule.haveProduct, haveProduct)
                    .where(haveProduct.product.type.eq(ProductType.valueOf(value))
                            .and(schedule.coordinate.coordinateId.eq(coordinateId)));
//                    .leftJoin(schedule.product, product)
//                    .where(product.type.eq(ProductType.valueOf(value)));
            case SCHEDULE_DATE -> from(schedule)
                    .where(schedule.dateTime.between(LocalDateTime.of(year, month, day, 0, 0), LocalDateTime.of(year, month, day, 23, 59))
                            .and(schedule.coordinate.coordinateId.eq(coordinateId)));
            case SCHEDULE_DATETIME -> from(schedule)
                    .where(schedule.dateTime.eq(LocalDateTime.of(year, month, day, hour, minute))
                            .and(schedule.coordinate.coordinateId.eq(coordinateId)));
            case SCHEDULE_STATUS -> from(schedule)
                    .where(schedule.status.eq(ScheduleStatus.valueOf(value))
                            .and(schedule.coordinate.coordinateId.eq(coordinateId)));
        };

        final List<Schedule> scheduleList = Objects.requireNonNull(getQuerydsl()).applyPagination(pageable, query).fetch();
        return new PageImpl<>(scheduleList,  pageable, query.fetchCount());
    }

}
