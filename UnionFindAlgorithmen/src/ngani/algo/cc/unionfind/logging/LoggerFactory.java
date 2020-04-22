package ngani.algo.cc.unionfind.logging;

/**
 * @author Diane Ngani
 *
 */
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used to create a Logger object with the configuration we want.
 * In this case, you're going to write all the log messages generated in the application to the a filename.log file 
 * and with the format specified in the FileFormatter class.
 * It uses the Logger class to create the Logger object. This class creates a Logger object per name that is passed as parameter.
 */
public class LoggerFactory {
	
	/**
	 * Handler to control that the log messages are written in a log file.
	 */
	private static Handler handler;
	
	/**
	 * Static method that returns the log object associated with the name received as parameter.
	 * If it's a new Logger object, this method configures it with your configuration. 
	 * @param name Name of the Logger object you want to obtain.
	 * @param filename Name of the file log. Including the ending.
	 * @return The Logger object generated.
	 */
	public synchronized static Logger getLogger(String name, String filename){
		/*
		 * Get the logger
		 */
		Logger logger=Logger.getLogger(name);
		/*
		 * Set the level to show all the messages
		 */
		logger.setLevel(Level.ALL);
		try {
			/*
			 * If the Handler object is null, we create one to
			 * write the log messages in the recipe6.log file
			 * with the format specified by the MyFormatter class
			 */
			if (handler==null) {
				handler=new FileHandler(filename);
				Formatter format=new DataFileFormatter();
				handler.setFormatter(format);
			}
			/*
			 * If the Logger object hasn't handler, we add the Handler object
			 * to it
			 */
			if (logger.getHandlers().length==0) {
				logger.addHandler(handler);
			}
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Return the Logger object.
		 */
		return logger;
	}
}