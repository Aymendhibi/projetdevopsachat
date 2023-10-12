package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class StockServiceImplTest {
    @Autowired
    private StockServiceImpl stockService;
    @Autowired
    private StockRepository stockRepository;
    @Test
    void retrieveAllStocks() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        assertNotNull(stocks);
    }

    @Test
    void addStock() {
        Stock stock = new Stock("Stock3", 25, 10);
        stockService.addStock(stock);
        Stock addedStock = stockRepository.findById(stock.getIdStock()).orElse(null);
        assertNotNull(addedStock);
    }
    @Test
    void deleteStock() {
        Stock stock = new Stock("Stock6", 30, 12);
        stockRepository.save(stock);
        stockService.deleteStock(stock.getIdStock());
        Stock deletedStock = stockRepository.findById(stock.getIdStock()).orElse(null);
        assertNull(deletedStock);
    }
    @Test
    void updateStock() {
        Stock stock = new Stock("Stock7", 35, 15);
        stockRepository.save(stock);
        stock.setLibelleStock("Stock7 Updated");
        stock.setQte(40);
        stock.setQteMin(20);
        stockService.updateStock(stock);
        Stock updatedStock = stockRepository.findById(stock.getIdStock()).orElse(null);
        assertNotNull(updatedStock);
        assertEquals("Stock7 Updated", updatedStock.getLibelleStock());
        assertEquals(40, updatedStock.getQte());
        assertEquals(20, updatedStock.getQteMin());
    }
    @Test
    void retrieveStock() {
        Stock stock = new Stock("Stock8", 45, 18);
        stockRepository.save(stock);
        Stock retrievedStock = stockService.retrieveStock(stock.getIdStock());
        assertNotNull(retrievedStock);
        assertEquals("Stock8", retrievedStock.getLibelleStock());
        assertEquals(45, retrievedStock.getQte());
        assertEquals(18, retrievedStock.getQteMin());
    }
    @Test
    void retrieveStatusStock() {

        Stock stock1 = new Stock("Stock1", 5, 10);
        Stock stock2 = new Stock("Stock2", 8, 15);
        stockRepository.save(stock1);
        stockRepository.save(stock2);
        String statusMessage = stockService.retrieveStatusStock();
        assertNotNull(statusMessage);
      assertTrue(statusMessage.contains("le stock Stock1 a une quantité de 5 inférieur à la quantité minimale a ne pas dépasser de 10"));
        assertTrue(statusMessage.contains("le stock Stock2 a une quantité de 8 inférieur à la quantité minimale a ne pas dépasser de 15"));

    }
}
