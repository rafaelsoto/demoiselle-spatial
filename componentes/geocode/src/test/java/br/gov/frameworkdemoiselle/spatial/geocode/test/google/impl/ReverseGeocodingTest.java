package br.gov.frameworkdemoiselle.spatial.geocode.test.google.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.gov.frameworkdemoiselle.spatial.geocode.ReverseGeocoding;
import br.gov.frameworkdemoiselle.spatial.geocode.google.impl.GeocodingReverseGeocodingImpl;
import br.gov.frameworkdemoiselle.spatial.geocode.model.GeocodingResponse;
import br.gov.frameworkdemoiselle.spatial.geocode.model.Language;

public class ReverseGeocodingTest {

	@Test
	public void searchLocation() {
		
		ReverseGeocoding impl = new GeocodingReverseGeocodingImpl();
		 
		GeocodingResponse response = impl.setLocation("-12.9710208","-38.48760780000001").search(true);
		
		assertTrue(response.getResults().get(0).getAddress().equals("R. Santa Maria Goretti, 1-237 - Vila Laura, Salvador - Bahia, 40270-210, Brazil"));		
		
	}
	
	@Test
	public void searchLocationAndLanguage() {
		
		ReverseGeocoding impl = new GeocodingReverseGeocodingImpl();
		 
		GeocodingResponse response = impl.setLocation("-12.9710208","-38.48760780000001").setLanguage(Language.Portuguese_Brazil).search(true);
		
		assertTrue(response.getResults().get(0).getAddress().equals("R. Santa Maria Goretti, 1-237 - Vila Laura, Salvador - BA, 40270-210, Brasil"));		
		
	}
}
