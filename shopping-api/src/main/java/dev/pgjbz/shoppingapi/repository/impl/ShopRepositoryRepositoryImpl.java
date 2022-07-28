package dev.pgjbz.shoppingapi.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dev.pgjbz.shoppingapi.dto.report.ShopReportDTO;
import dev.pgjbz.shoppingapi.dto.request.ShopFilterDTO;
import dev.pgjbz.shoppingapi.dto.request.ShopReportFilterDTO;
import dev.pgjbz.shoppingapi.models.Shop;
import dev.pgjbz.shoppingapi.repository.ShopReportRepository;

@Repository
public class ShopRepositoryRepositoryImpl implements ShopReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Shop> findShopByFilter(ShopFilterDTO filter) {
        var jpql = buildFindByFilterQuery(filter);
        var query = buildFindByFilterQuery(jpql, filter);
        return query.getResultList();
    }

    @Override
    public ShopReportDTO findReportByDate(ShopReportFilterDTO filter) {
        final String sql = buildNativeQueryToReportByDate();
        final Query query = buildQueryToReportByDate(sql, filter);
        return buildReport(query);
    }

    private final ShopReportDTO buildReport(Query query) {
        Object[] result = (Object[])query.getSingleResult();

        return new ShopReportDTO(
            ((BigInteger)result[0]).intValue(),
            (Double)result[1],
            (Double)result[2]
        );
    }

    private final String buildNativeQueryToReportByDate() {
        return """
                select 
                    count(sp.id) as quantity, 
                    sum(sp.total) as total, 
                    avg(sp.total) as avarage
                from
                    shopping.shop sp
                where
                    sp.date between :startDate and :endDate
                """;
    }

    private final Query buildQueryToReportByDate(String sql, ShopReportFilterDTO filter) {
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("startDate", filter.startDate());
        query.setParameter("endDate", filter.endDate());
        return query;
    }

    private final Query buildFindByFilterQuery(String jpql, ShopFilterDTO filter) {
        Query query = entityManager.createQuery(jpql);
        query.setParameter("startDate", filter.startDate());
        filter.endDate().ifPresent(v -> query.setParameter("endDate", v));
        filter.minValue().ifPresent(v -> query.setParameter("minValue", v));
        return query;
    }

    private final String buildFindByFilterQuery(ShopFilterDTO filter) {
        var query = new StringBuilder("select s from Shop s where s.date >= :startDate");
        filter.endDate().ifPresent(v -> query.append(" and s.date <= :endDate"));
        filter.minValue().ifPresent(v -> query.append(" and s.total >= :minValue"));
        return query.toString();
    }

}
