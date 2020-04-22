/**
 * 
 */
package ngani.algo.cc.unionfind.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * This class is used to format the log messages. The Logger class call the
 * format() method to get the formatted log message that it's going to write.
 * The format method receives a LogRecord object as parameter. That object has
 * all the information about the message.
 *
 */
public class DataFileFormatter extends Formatter {

	/**
	 * Method that formats the log message. It's declared as abstract in the
	 * Formatter class. It's called by the Logger class. It receives a LogRecord
	 * object as parameter with all the information of the log message
	 */
	@Override
	public String format(LogRecord record) {

		/*
		 * Create a string buffer to construct the message.
		 */
		StringBuilder sb = new StringBuilder();

		/*
		 * Add the parts of the message with the desired format.
		 */

		//sb.append("[" + record.getLevel() + "] - ");
		sb.append(record.getSourceClassName() + ";" + record.getSourceMethodName() + ";");
		
		Object[] params = record.getParameters();
		for (Object param : params) { 
			sb.append(param.toString() + ";");
		}

		sb.append(record.getMessage()+";"); // Give the extra message of the logger back.
		sb.append(record.getInstant().getNano()+"\n");

		/*
		 * Convert the string buffer to string and return it
		 */
		return sb.toString();
	}
}