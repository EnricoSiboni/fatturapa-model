package com.github.siboxd.fatturapa.model.invoicebody.general;

import com.github.siboxd.fatturapa.model.invoicebody.Ritenuta;
import com.github.siboxd.fatturapa.testutils.AbstractXmlSerializationTest;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Files;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Test class for {@link DatiGeneraliDocumento} serialization
 *
 * @author Enrico
 */
class DatiGeneraliDocumentoTest extends AbstractXmlSerializationTest {

    private static final String EXAMPLES_RESOURCE_FOLDER = "partial_examples/invoice_body/general_data/document_general";

    @Test
    void exampleDatiGeneraliDocumento_1() throws URISyntaxException {
        final String testFileName = "DatiGeneraliDocumento_1.xml";
        assumeTrue(Files.exists(resolveResourcePath(EXAMPLES_RESOURCE_FOLDER, testFileName)));

        final DatiGeneraliDocumento testObj = new DatiGeneraliDocumento();
        fillCommonGeneralPart(testObj);

        final DatiRitenuta datiRitenuta = new DatiRitenuta();
        datiRitenuta.setTipoRitenuta(TipoRitenuta.RT01);
        datiRitenuta.setImportoRitenuta("240.25");
        datiRitenuta.setAliquotaRitenuta("20.00");
        datiRitenuta.setCausalePagamento(CausalePagamento.A);

        testObj.setDatiRitenuta(datiRitenuta);

        persistAndCheck(testObj, EXAMPLES_RESOURCE_FOLDER, testFileName);
    }

    @Test
    void exampleDatiGeneraliDocumento_2() throws URISyntaxException {
        final String testFileName = "DatiGeneraliDocumento_2.xml";
        assumeTrue(Files.exists(resolveResourcePath(EXAMPLES_RESOURCE_FOLDER, testFileName)));

        final DatiGeneraliDocumento testObj = new DatiGeneraliDocumento();
        fillCommonGeneralPart(testObj);

        final DatiCassaPrevidenziale datiCassa1 = new DatiCassaPrevidenziale();
        datiCassa1.setTipoCassa(TipoCassa.TC22);
        datiCassa1.setAlCassa("4.00");
        datiCassa1.setImportoContributoCassa("60.00");
        datiCassa1.setImponibileCassa("1500.00");
        datiCassa1.setAliquotaIVA("21.00");
        datiCassa1.setRitenuta(Ritenuta.SI);

        final DatiCassaPrevidenziale datiCassa2 = new DatiCassaPrevidenziale();
        datiCassa2.setTipoCassa(TipoCassa.TC03);
        datiCassa2.setAlCassa("2.00");
        datiCassa2.setImportoContributoCassa("31.20");
        datiCassa2.setImponibileCassa("1560.00");
        datiCassa2.setAliquotaIVA("21.00");

        testObj.setDatiCassaPrevidenziale(asList(datiCassa1, datiCassa2));

        persistAndCheck(testObj, EXAMPLES_RESOURCE_FOLDER, testFileName);
    }

    /**
     * Shorthand method to set common mandatory part of the tested object
     *
     * @param datiGeneraliDocumento the object to be filled
     */
    private void fillCommonGeneralPart(final DatiGeneraliDocumento datiGeneraliDocumento) {
        datiGeneraliDocumento.setTipoDocumento(TipoDocumento.TD01);
        datiGeneraliDocumento.setDivisa("EUR");
        datiGeneraliDocumento.setData("2012-03-10");
        datiGeneraliDocumento.setNumero("A-2012-15");
    }

}
