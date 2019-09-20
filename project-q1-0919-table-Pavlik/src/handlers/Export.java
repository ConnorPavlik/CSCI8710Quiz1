 
package handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import analysis.ProjectAnalyzer;
import model.ModelProvider;
import model.ProgramElement;
import util.FileUtil;

public class Export {
	@Execute
	public void execute(Shell shell) {
		ModelProvider.INSTANCE.clearProgramElements();
        try {
           ProjectAnalyzer analyzer = new ProjectAnalyzer();
           analyzer.analyze();
        } catch (Exception e2) {
           e2.printStackTrace();
        }
        List<String> outLines = new ArrayList<String>();
        for(ProgramElement pe : ModelProvider.INSTANCE.getProgramElements()) {
        	String line = pe.getPkgName() + ", " + pe.getClassName() + ", " +
        			pe.getMethodName() + ", " + pe.isReturnVoid() + ", " +
        			pe.isPublicMethod();
        	outLines.add(line);
        	
        }
        try {
			FileUtil.saveFile("/Users/pav/Downloads/prj001/output.csv", outLines);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        MessageDialog.openInformation(shell, "Count of Rows", "Count of Rows: " + outLines.size());
	}
		
}