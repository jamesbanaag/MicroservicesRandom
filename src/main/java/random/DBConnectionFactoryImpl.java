package random;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionFactoryImpl extends DBConnectionFactory{

    @Override
    public Connection getConnection() {
    	
    	Properties prop = new Properties();
    	InputStream input = null;
    	
        try {
        	if (prop.getProperty("use.database").equals("true")) {
        	input = new FileInputStream("config/application.properties");
        	
        	prop.load(input);
            Class.forName(prop.getProperty("db.drivername"));
            Connection conn = 
                    DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.username"), prop.getProperty("db.password"));
            return conn;
        	}
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
        return null;
    }
    
}
