package model;

import java.util.Hashtable;

public class Interpolator {
    private InterpolationMethod interpolationModel;
    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private final String DEFAULT_METHOD = CS_METHOD;
    Hashtable<String, InterpolationMethod> methods;
    
	 public Interpolator() {
		 methods = new Hashtable<String, InterpolationMethod>();
		
		//default methods
		addMethod(CS_METHOD, new CubicSpline());
		addMethod(L_METHOD, new Lagrange());
        
		
		bind();
     }

    public void bind() {
        interpolationModel = (InterpolationMethod) getMethod(DEFAULT_METHOD);
    }
    
    public void addMethod(String methodName, InterpolationMethod newInterpolationMethod){
    	methods.put(methodName, newInterpolationMethod);
    }

	
	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
	public InterpolationMethod getMethod() { return interpolationModel; }
    public InterpolationMethod getMethod(String methodName) {
    	if(methods.containsKey(methodName)){
    		interpolationModel = methods.get(methodName);
    	}else{
        	System.out.println("Unknown method " + methodName);
    	}
        return interpolationModel;
    }
}
