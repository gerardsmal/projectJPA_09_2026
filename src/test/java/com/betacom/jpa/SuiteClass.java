package com.betacom.jpa;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.betacom.jpa.abbonamento.AbbonamentoTest;
import com.betacom.jpa.attivita.AttivitaTest;
import com.betacom.jpa.certificato.CertificatoTest;
import com.betacom.jpa.socio.SocioControllerTest;
import com.betacom.jpa.socio.SocioServiceTest;

@Suite
@SelectClasses({
	SocioServiceTest.class,
	SocioControllerTest.class,
	CertificatoTest.class,
	AttivitaTest.class,
	AbbonamentoTest.class
	
})

public class SuiteClass {

}
