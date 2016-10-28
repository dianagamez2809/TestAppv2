package test;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import com.diana.dao.CiudadDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestDAO extends TestCase{

	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	public static Test suite() {
		return new TestSuite(TestDAO.class);
	}
	
	//Method to test the listCiudades() method of the CiudadDAO
	public void testListCiudades()
	{
		List<Ciudad> ciudad = null;
		try{
	
		CiudadDAO ciudaddao = new CiudadDAO();
	
		ciudad = ciudaddao.listCiudades();
	
		System.out.println("Value of Resultset =>"+ciudad);
		if(ciudad!=null)
		{
			for (Iterator iterator = 
                    ciudad.iterator(); iterator.hasNext();){
				Ciudad c = (Ciudad) iterator.next();
				System.out.println("ID_CIUDAD : "+c.getId());
				System.out.println("NOMBRE_CIUDAD "+c.getNombreCiudad());
				System.out.println("ID_PAIS "+c.getPais().getId());
				System.out.println("NOMBRE_PAIS" + c.getPais().getNombrePais());
				System.out.println("VALOR_CIUDAD" + c.getValorCiudad());
				System.out.println("NUMERO_SEDE" + c.getSedes().size());
				for (Iterator iterator1 = 
	                   c.getSedes().iterator(); iterator1.hasNext();){
					Sede sede = (Sede) iterator1.next();
					System.out.println(sede.getTipo().getDescripcion());
				}   
			}
		}
	
		}catch(Exception excp){
		throw new AssertionFailedError() ;
	
		}

	}
	
	// Method to verify that Paris has been Sede twice
	public void testParis()
	{
		List<Ciudad> ciudad = null;
		try{
	
		CiudadDAO ciudaddao = new CiudadDAO();
	
		ciudad = ciudaddao.listCiudades();
	
		System.out.println("Value of Resultset =>"+ciudad);
		if(ciudad!=null)
		{
			for (Iterator iterator = 
                    ciudad.iterator(); iterator.hasNext();){
				Ciudad c = (Ciudad) iterator.next();
				if( c.getSedes().size() == 2){
					System.out.println(c.getNombreCiudad());
					break;
				}
				
			}
		}
	
		}catch(Exception excp){
		throw new AssertionFailedError() ;
	
		}

	}
	
}
