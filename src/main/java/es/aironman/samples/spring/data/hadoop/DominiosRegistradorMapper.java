package es.aironman.samples.spring.data.hadoop;

import java.io.IOException;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DominiosRegistradorMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

	private static final String SEPARATOR = ";";

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException,
			InterruptedException {
		
		final String[] values = value.toString().split(SEPARATOR);
		String agent ;
		String totalDomains;
		for (int i=0;i<values.length;i++){
		/**
		 * id ; Agente Registrador   ; Total dominios;
		 * 1  ; 1&1 Internet		    ; 382.972;
		 * 36 ; WEIS CONSULTING	    ; 4.154;
		 * 71 ; MESH DIGITAL LIMITED ; 910;
		 * 
		 * */
			agent = format(values[1]);
			totalDomains = format(values[2]);
			
	
			if (NumberUtils.isNumber(totalDomains.toString() ) ){
				context.write(new Text(agent), new DoubleWritable(NumberUtils.toDouble(totalDomains)));
			}
			
		}//del for
	}
	private String format(String value) {
		return value.trim();
	}

}
