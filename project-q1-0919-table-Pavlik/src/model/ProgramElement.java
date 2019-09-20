package model;

public class ProgramElement {
	private String		pkgName;
	private String		className;
	private String		methodName;
	private boolean	isReturnVoid;
	private boolean	isPublicMethod;

	public ProgramElement() {
	}

	public ProgramElement(String pkgName, String className, String methodName, 
			boolean isRetVoid, boolean isPub) {
		this.pkgName = pkgName;
		this.className = className;
		this.methodName = methodName;
		this.isReturnVoid = isRetVoid;
		this.isPublicMethod = isPub;
	}

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public boolean isReturnVoid() {
		return isReturnVoid;
	}

	public void setReturnVoid(boolean isReturnVoid) {
		this.isReturnVoid = isReturnVoid;
	}

	public boolean isPublicMethod() {
		return isPublicMethod;
	}

	public void setPublicMethod(boolean isPub) {
		this.isPublicMethod = isPub;
	}
	

	@Override
	public String toString() {
		return pkgName + "." + className + "." + methodName;
	}
}
