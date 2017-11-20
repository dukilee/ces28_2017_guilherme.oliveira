package presenter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

import model.Interpolator;

public class MyInterpolationApp  {
    private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
    private double _value, result;
    private File _file;
    private Vector<Double> x, y;
    private DecimalFormat formatResult = new DecimalFormat("####.######");
    private Interpolator interpolator;
    
    public MyInterpolationApp() {
    	interpolator = new Interpolator();
    }

    public File getDataFile() {
        return _file;
    }
    
    public void setMethod(String methodName){
    	interpolator.getMethod(methodName);
    }
    
    // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
    public void calculateResult(float value, File file) {
        _value = value;
        buildDataPoints(file);
        if(interpolator.getMethod() != null) {
            result = interpolator.getMethod().calculateResult(_value, x, y);
            printResult();
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
    }

 // RESPONSABILITY: IMPRIMIR RESULTADOS
    private void printResult() {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + getDataFile());
    	System.out.println("Interp at " + formatResult.format(_value) + " ; result = " + formatResult.format(result));
	}

    // RESPONSABILITY: LER ARQUIVO DE DADOS
	private void buildDataPoints(File file) {
        if(file == null)
           return;
        else _file = file;

        x = new Vector<Double>();
        y = new Vector<Double>();
        try {
            input = new FileReader(_file);
		    /* Filter FileReader through a Buffered read to read a line at a time */
            bufRead = new BufferedReader(input);
            // Read first line
            String line = bufRead.readLine();
            // Read through file one line at time.
            while (line != null){
                xy = new StringTokenizer(line, "\t ");
                while(xy.hasMoreTokens()) {
                    x.addElement(Double.parseDouble(xy.nextToken()));
                    y.addElement(Double.parseDouble(xy.nextToken()));
                }
                line = bufRead.readLine();
            }
            bufRead.close();
        } catch (IOException e) { // If another exception is generated, print a stack trace
            e.printStackTrace();
        }
    }//buildDataPoints


}//class
