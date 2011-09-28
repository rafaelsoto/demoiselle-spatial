package br.gov.frameworkdemoiselle.spatial.component.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;


@FacesConverter(forClass = Geometry.class)
public class GeometryConverter implements Converter {

	@Inject
    Logger logger;
	
   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Geometry geom = null;
       if (value != null) {
           try {
               WKTReader reader = new WKTReader();
               geom = reader.read(value);
               geom.setSRID(4326);
           } catch (ParseException ex) {
               logger.error("ParserErro on JSF Converter", ex);
           }

       }
       return geom;
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
       return value.toString();
   }
}
