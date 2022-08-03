package dev.pgjbz.shoppingapi.repository;

import java.util.List;

import dev.pgjbz.core.dto.report.ShopReportDTO;
import dev.pgjbz.core.dto.request.ShopFilterDTO;
import dev.pgjbz.core.dto.request.ShopReportFilterDTO;
import dev.pgjbz.shoppingapi.models.Shop;

public interface ShopReportRepository {

    List<Shop> findShopByFilter(ShopFilterDTO filter);
    ShopReportDTO findReportByDate(ShopReportFilterDTO filter);

}
