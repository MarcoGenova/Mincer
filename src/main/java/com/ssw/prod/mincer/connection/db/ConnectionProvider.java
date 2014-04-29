/**
 * 
 */
package com.ssw.prod.mincer.connection.db;

import com.ssw.prod.mincer.exceptions.MincerException;
import java.sql.Connection;

/**
 * @author m.genova
 * @since 0.0.1
 */
public interface ConnectionProvider {

	public void start(String...params) throws MincerException;
        
        public void stop(String...params) throws MincerException;
        
        public Connection getConnection (String...params) throws MincerException;
        
        public void closeConnection (Connection connection, String...params) throws MincerException;
}
