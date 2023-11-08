import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class FactureTest {
    @MockBean
    private FactureRepository factureRepository;

    @Autowired
    private FactureServiceImpl factureService;

  /*  @Test
    void testRetrieveAllFactures() {
        ArrayList<Facture> factureList = new ArrayList<>();
        when(factureRepository.findAll()).thenReturn(factureList);
        List<Facture> actualRetrieveAllFacturesResult = factureService.retrieveAllFactures();
        assertSame(factureList, actualRetrieveAllFacturesResult);
        assertTrue(actualRetrieveAllFacturesResult.isEmpty());
        verify(factureRepository).findAll();


    }*/
}
