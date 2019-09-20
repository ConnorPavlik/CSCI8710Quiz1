 
package handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import analysis.ProjectAnalyzer;
import model.ModelProvider;
import model.ProgramElement;

public class Count {
	@Execute
	public void execute(Shell shell) {
		ModelProvider.INSTANCE.clearProgramElements();
        try {
           ProjectAnalyzer analyzer = new ProjectAnalyzer();
           analyzer.analyze();
        } catch (Exception e2) {
           e2.printStackTrace();
        }
        List<String> packages = new ArrayList<String>();
        List<String> classes = new ArrayList<String>();
        List<String> methods = new ArrayList<String>();
        for(ProgramElement pe : ModelProvider.INSTANCE.getProgramElements()) {
        	if(!classes.contains(pe.getClassName())) {
        		classes.add(pe.getClassName());
        	}
        	if(!packages.contains(pe.getPkgName())) {
        		packages.add(pe.getPkgName());
        	}
        	if(!methods.contains(pe.getMethodName())) {
        		methods.add(pe.getMethodName());
        	}
        	
        
		}
        MessageDialog.openInformation(shell, "Count Packages, Classes, and Methods", "Info: Found " 
        		+ packages.size()+ " packages, " + classes.size()+ " classes,"
        		+ methods.size()+ " methods in total");
	}
		
}