package com.github.siboxd.fatturapa.model.invoiceheader.supplier;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Indicates whether the company is in liquidation or not
 */
@Root(name = "StatoLiquidazione")
@Namespace(reference = "http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2")
public enum StatoLiquidazione {

    /**
     * Company in liquidation
     */
    LS,
    /**
     * Company not in liquidation
     */
    LN

}
