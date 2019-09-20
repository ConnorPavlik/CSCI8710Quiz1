package model;

import java.util.ArrayList;
import java.util.List;

public enum ModelProvider {
   INSTANCE;

   private List<ProgramElement> progElements = new ArrayList<ProgramElement>();;

   private ModelProvider() {
   }

   public void addProgramElements(String pkgName, String className, 
		   String methodName, boolean isRetVoid, boolean isPub) {
      progElements.add(new ProgramElement(pkgName, className, methodName, 
    		  isRetVoid, isPub));
   }

   public List<ProgramElement> getProgramElements() {
      return progElements;
   }

   public void clearProgramElements() {
      progElements.clear();
   }
}
