package by.itechart.katstock.web.service;

import by.itechart.katstock.entity.Stock;
import by.itechart.katstock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 */
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStocks(Long companyId) {

        return stockRepository.findByStockOrganizationStockOrganizationId(companyId);
    }

    public Stock getStock(Long id) {

        return stockRepository.findOne(id);
    }
}
