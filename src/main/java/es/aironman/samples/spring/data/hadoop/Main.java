package es.aironman.samples.spring.data.hadoop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Alonso Isidoro Roman
 */
public class Main {
    public static void main(String[] arguments) {
    	//launching spring application context
        @SuppressWarnings("unused")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
