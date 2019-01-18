package com.github.siboxd.fatturapa.model;

import com.github.siboxd.fatturapa.model.invoiceheader.IdFiscaleType;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


/**
 * DatiAnagraficiCessionarioType<br>
 * Generated using Android JAXB<br>
 *
 * @link https://github.com/yeshodhan/android-jaxb
 */
@Root(name = "DatiAnagraficiCessionarioType")
public class DatiAnagraficiCessionarioType {

    @Element(name = "IdFiscaleIVA", required = false)
    private IdFiscaleType idFiscaleIVA;
    @Element(name = "CodiceFiscale", required = false)
    private String codiceFiscale;
    @Element(name = "Anagrafica", required = true)
    private AnagraficaType anagrafica;

    public DatiAnagraficiCessionarioType() {
    }

    public IdFiscaleType getIdFiscaleIVA() {
        return idFiscaleIVA;
    }

    public void setIdFiscaleIVA(IdFiscaleType idFiscaleIVA) {
        this.idFiscaleIVA = idFiscaleIVA;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public AnagraficaType getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(AnagraficaType anagrafica) {
        this.anagrafica = anagrafica;
    }

}
