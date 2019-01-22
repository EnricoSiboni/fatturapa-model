package com.github.siboxd.fatturapa.model.invoiceheader.supplier;

import com.github.siboxd.fatturapa.model.invoicecommon.Anagrafica;
import com.github.siboxd.fatturapa.model.invoicecommon.IdFiscale;
import com.github.siboxd.fatturapa.model.invoicecommon.Indirizzo;
import com.github.siboxd.fatturapa.testutils.AbstractXmlSerializationTest;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * A test class for {@link CedentePrestatore}
 *
 * @author Enrico
 */
class CedentePrestatoreTest extends AbstractXmlSerializationTest {

    private static final String EXAMPLES_RESOURCE_FOLDER = "partial_examples/invoice_header/supplier";

    @Test
    void exampleCedentePrestatore_1() throws URISyntaxException {
        final String testFileName = "CedentePrestatore_1.xml";
        assumeTrue(Files.exists(resolveResourcePath(EXAMPLES_RESOURCE_FOLDER, testFileName)));

        final IdFiscale idFiscale = new IdFiscale();
        idFiscale.setIdPaese("IT");
        idFiscale.setIdCodice("01234567890");

        final Anagrafica anagrafica = new Anagrafica();
        anagrafica.setDenominazione("AlphaBeta Srl");

        final DatiAnagraficiCedente datiAnagrafici = new DatiAnagraficiCedente();
        datiAnagrafici.setIdFiscaleIVA(idFiscale);
        datiAnagrafici.setCodiceFiscale("98765432109");
        datiAnagrafici.setAnagrafica(anagrafica);
        datiAnagrafici.setRegimeFiscale(RegimeFiscale.RF01);

        final Indirizzo indirizzo = new Indirizzo();
        indirizzo.setIndirizzo("Via Nazionale, 443");
        indirizzo.setCap("40100");
        indirizzo.setComune("Bologna");
        indirizzo.setProvincia("BO");
        indirizzo.setNazione("IT");

        final IscrizioneREA iscrizioneREA = new IscrizioneREA();
        iscrizioneREA.setUfficio("BO");
        iscrizioneREA.setNumeroREA("102030");
        iscrizioneREA.setCapitaleSociale("500000.00");
        iscrizioneREA.setSocioUnico(SocioUnico.SU);
        iscrizioneREA.setStatoLiquidazione(StatoLiquidazione.LN);

        final Contatti contatti = new Contatti();
        contatti.setTelefono("051456789");
        contatti.setFax("051456799");
        contatti.setEmail("amministrazione@alphabeta.it");

        final CedentePrestatore testObj = new CedentePrestatore();
        testObj.setDatiAnagrafici(datiAnagrafici);
        testObj.setSede(indirizzo);
        testObj.setIscrizioneREA(iscrizioneREA);
        testObj.setContatti(contatti);
        testObj.setRiferimentoAmministrazione("AD10BB");

        persistAndCheck(testObj, EXAMPLES_RESOURCE_FOLDER, testFileName);
    }

    @Test
    void exampleCedentePrestatore_2() throws URISyntaxException {
        final String testFileName = "CedentePrestatore_2.xml";
        assumeTrue(Files.exists(resolveResourcePath(EXAMPLES_RESOURCE_FOLDER, testFileName)));

        final IdFiscale idFiscale = new IdFiscale();
        idFiscale.setIdPaese("IT");
        idFiscale.setIdCodice("09988776600");

        final Anagrafica anagrafica = new Anagrafica();
        anagrafica.setNome("Giovanni");
        anagrafica.setCognome("Verdi");
        anagrafica.setTitolo("Dott.");

        final DatiAnagraficiCedente datiAnagrafici = new DatiAnagraficiCedente();
        datiAnagrafici.setIdFiscaleIVA(idFiscale);
        datiAnagrafici.setCodiceFiscale("VRDGNN99B99H501P");
        datiAnagrafici.setAnagrafica(anagrafica);
        datiAnagrafici.setAlboProfessionale("Dottori Commercialisti");
        datiAnagrafici.setProvinciaAlbo("RM");
        datiAnagrafici.setNumeroIscrizioneAlbo("111222333444");
        datiAnagrafici.setDataIscrizioneAlbo("2005-10-30");
        datiAnagrafici.setRegimeFiscale(RegimeFiscale.RF02);

        final Indirizzo indirizzo = new Indirizzo();
        indirizzo.setIndirizzo("Piazza S. Vincenzo");
        indirizzo.setNumeroCivico("12 C");
        indirizzo.setCap("00133");
        indirizzo.setComune("Roma");
        indirizzo.setProvincia("RM");
        indirizzo.setNazione("IT");

        final Contatti contatti = new Contatti();
        contatti.setTelefono("3381110000");
        contatti.setFax("061234567");
        contatti.setEmail("gverdi@abc.it");

        final CedentePrestatore testObj = new CedentePrestatore();
        testObj.setDatiAnagrafici(datiAnagrafici);
        testObj.setSede(indirizzo);
        testObj.setContatti(contatti);
        testObj.setRiferimentoAmministrazione("C109033");

        persistAndCheck(testObj, EXAMPLES_RESOURCE_FOLDER, testFileName);
    }

}
