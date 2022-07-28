package dev.pgjbz.shoppingapi.repository;

import java.util.List;

import dev.pgjbz.shoppingapi.dto.report.ShopReportDTO;
import dev.pgjbz.shoppingapi.dto.request.ShopFilterDTO;
import dev.pgjbz.shoppingapi.dto.request.ShopReportFilterDTO;
import dev.pgjbz.shoppingapi.models.Shop;

public interface ShopReportRepository {

    List<Shop> findShopByFilter(ShopFilterDTO filter);
    ShopReportDTO findReportByDate(ShopReportFilterDTO filter);

}
