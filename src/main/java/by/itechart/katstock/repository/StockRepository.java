package by.itechart.katstock.repository;

import by.itechart.katstock.entity.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 */
public interface StockRepository extends CrudRepository<Stock, Long> {

    List<Stock> findByStockOrganizationStockOrganizationId(Long id);
}
