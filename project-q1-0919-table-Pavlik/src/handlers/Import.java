 
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
import view.Viewer;

public class Import {
	@Execute
	public void execute(Shell shell) {
		ModelProvider.INSTANCE.clearProgramElements();
		List<String> file = null;
        try {
           file = FileUtil.readFile("/Users/pav/Downloads/input.csv");
        } catch (Exception e2) {
           e2.printStackTrace();
        }
        for(String str : file) {
        	String[] split = str.split(",");
        	ModelProvider.INSTANCE.addProgramElements(split[0], split[1], split[2],split[3] == "TRUE", split[4] == "1");
        }
        Viewer view = new Viewer();
       
        MessageDialog.openInformation(shell, "Import", "Info: Imported" + file.size() + "lines");
	}
		
}