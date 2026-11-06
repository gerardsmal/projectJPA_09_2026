package com.betacom.jpa;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.betacom.jpa.socio.SocioControllerTest;
import com.betacom.jpa.socio.SocioServiceTest;

@Suite
@SelectClasses({
	SocioServiceTest.class,
	SocioControllerTest.class	
})

public class SuiteClass {

}
