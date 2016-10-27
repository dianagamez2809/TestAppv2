import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.diana.dao.CiudadDAO;
import com.diana.dao.SedeDAO;
import com.diana.dao.TipoDAO;
import com.diana.model.Ciudad;
import com.diana.model.Sede;
import com.diana.model.Tipo;

public class Editar {
	public Editar(Shell parent, int id, int idtipo) {
		SedeDAO sededao = new SedeDAO();
		CiudadDAO ciudaddao = new CiudadDAO();
		TipoDAO tipodao = new TipoDAO();
		
		Sede s = sededao.getSede(id, idtipo);
		
		System.out.println(s);
	    Shell child = new Shell(parent);
	    child.setSize(400, 200);
	    child.setText("Crear nueva Sede");
	    child.setLayout(new GridLayout(2, false));
	    
	    Label anoLabel = new Label(child, SWT.NONE);
	    anoLabel.setText("Ano:");
		
		Text ano = new Text(child, SWT.BORDER);
		ano.setText(sededao.getSede(id, idtipo).getAno().toString());
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		ano.setLayoutData(gridData);
	    
	    Label cLabel = new Label(child, SWT.NONE);
		cLabel.setText("Ciudad:");
	    Combo c = new Combo(child, SWT.DROP_DOWN | SWT.BORDER);
	    c.add("Seleccionar", 0);
	    for(Ciudad ciudad : ciudaddao.listCiudades()) {
	        c.add(ciudad.getNombreCiudad(), ciudad.getId());
	    }
	    c.select(sededao.getSede(id, idtipo).getCiudad().getId());
	    gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		c.setLayoutData(gridData);
	    
		Label tLabel = new Label(child, SWT.NONE);
		tLabel.setText("Tipo:");
	    Combo t = new Combo(child, SWT.DROP_DOWN | SWT.BORDER);
	    t.add("Seleccionar", 0);
	    for(Tipo tipo : tipodao.getTipos()) {
	        t.add(tipo.getDescripcion(), tipo.getId());
	    }
	    t.select(sededao.getSede(id, idtipo).getTipo().getId());
	    gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		t.setLayoutData(gridData);
	    
	    // Button to edit record
	    Button buttonsave = new Button(child, SWT.PUSH);
	    buttonsave.setText("Editar");
	    buttonsave.setLayoutData(new RowData(240, 40));
	    // Function to save edited record
	    buttonsave.addListener(SWT.Selection, new Listener(){
	    	public void handleEvent(Event event){
	    		
	    		s.setAno(Integer.parseInt(ano.getText()));
	    		Tipo tipo = tipodao.getTipo(t.getSelectionIndex());
		        Ciudad ciudad = ciudaddao.getCiudad(c.getSelectionIndex());
		        s.setTipo(tipo);
		        s.setCiudad(ciudad);
		        sededao.updateSede(s);
		        child.dispose();
	    	}
	    });
	    
	    // Button to close screen
		Button buttoncancel = new Button(child, SWT.PUSH);
		buttoncancel.setText("Cancel");
		buttoncancel.setLayoutData(new RowData(240, 40));
		// Function to close screen
	    buttoncancel.addListener(SWT.Selection, new Listener() {
	        @Override
	        public void handleEvent(Event event) {
                child.dispose();
            }
	    });
	    
	    gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		buttonsave.setLayoutData(gridData);
		buttoncancel.setLayoutData(gridData);
	    
	    child.open();
	    
	}
}
