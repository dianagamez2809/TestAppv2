import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Editar {
	public Editar(Shell parent, int id, int sede) {
	    Shell child = new Shell(parent);
	    child.setSize(500, 300);
	    child.setText("Editar Sede");
	    GridLayout gridLayoutChild = new GridLayout();
	    gridLayoutChild.numColumns = 1;
	    child.setLayout(gridLayoutChild);
	    RowLayout rowLayout1 = new RowLayout();
	    child.setLayout(rowLayout1);
	    
	    // Button to edit record
	    Button buttonsave = new Button(child, SWT.PUSH);
	    buttonsave.setText("Editar");
	    buttonsave.setLayoutData(new RowData(240, 40));
	    // Function to save edited record
	    
	    
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
	    
	    child.open();
	    
	}
}
