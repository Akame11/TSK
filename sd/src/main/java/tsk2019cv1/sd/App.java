package tsk2019cv1.sd;

import org.junit.jupiter.api.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    

    public boolean isTriangle(int a, int b, int c) {
    	if(a<=0 || b<= 0 || c<=0) {
    		return false;
    	}
    	if(a+b<=c) {
    		return false;
    	}
    	if(c+b<=a) {
    		return false;
    	}
    	if(a+c<=b) {
    		return false;
    	}
    	return true;
    }
}
