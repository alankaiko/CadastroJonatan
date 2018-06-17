package br.com.jonatan.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("telefoneConverter")
public class FacesConverterTelefone implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String telefone) {
		if (telefone.trim().equals("")) {
            return null;
        } else {
        	return telefone.replaceAll("[() -]", "");
        }
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uIcomponent, Object object) {
		 return object.toString();
	}
	
}
