package patternFactory;

import models.Cafe;
import models.Viennoiserie;

public class gestionFactory {
	public Factory getFactory(String s)
	{
		if(s==null)
		{
			return null;
		}
		else if(s.equalsIgnoreCase("Cafe"))
		{
			return new Cafe();
		}
		else if(s.equalsIgnoreCase("Viennoiseries"))
		{
			return new Viennoiserie();
		}
		
		return null;
	}
	}
