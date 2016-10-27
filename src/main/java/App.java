/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diana
 */
import com.diana.dao.SedeDAO;
import com.diana.dao.CiudadDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;
import com.diana.model.Tipo;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class App {

    public static void main(String[] args) {
       // SedeDAO sededao = new SedeDAO();
        CiudadDAO ciudaddao = new CiudadDAO();
        //Display display = new Display ();
		//Shell shell = new Shell(display);
		
		//Text helloWorldTest = new Text(shell, SWT.NONE);
		for (Ciudad ciudad : ciudaddao.listCiudades()) {
			//helloWorldTest.setText(iter.toString());
			System.out.println("ID_PAIS " + ciudad.getPais().getId());
			System.out.println("NOMBRE_PAIS " + ciudad.getPais().getNombrePais());
			System.out.println("ID_CIUDAD " + ciudad.getId());
			System.out.println("NOMBRE_CIUDAD " + ciudad.getNombreCiudad());
			if(ciudad.getValorCiudad() == null){
				System.out.println("VALOR P " + ciudad.getPais().getValorPais());
			}
			else{
				System.out.println("VALOR " + ciudad.getValorCiudad());
			}
			System.out.println("NUMERO_SEDE " + ciudad.getSedes().size());
			for (Iterator iterator = 
                    ciudad.getSedes().iterator(); iterator.hasNext();){
				Sede sede = (Sede) iterator.next();
				System.out.println("DESCRIPCION " + sede.getTipo().getDescripcion());
			}
        }
		
		//helloWorldTest.pack();
		
		//shell.pack();
		//shell.open ();
		//while (!shell.isDisposed ()) {
			//if (!display.readAndDispatch ()) display.sleep ();
		//}
		//display.dispose ();

        
    }

}
