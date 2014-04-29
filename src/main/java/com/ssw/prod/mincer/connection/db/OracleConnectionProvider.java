/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssw.prod.mincer.connection.db;

import com.ssw.prod.mincer.exceptions.MincerException;
import com.ssw.prod.mincer.utils.log.LogUtil;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author m.genova
 */
public class OracleConnectionProvider implements ConnectionProvider {
    static final Logger LOG = LoggerFactory.getLogger(OracleConnectionProvider.class);
    
    private PoolDataSource pds;
    
    public void start(String... params) throws MincerException {
        //Creating a pool-enabled data source
         pds = PoolDataSourceFactory.getPoolDataSource();
        
        try {
            pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
            pds.setURL("jdbc:oracle:thin:@//10.26.3.35:1521/CK4");
            pds.setUser("CKB");
            pds.setPassword("logreply");

            //Setting pool properties
            pds.setInitialPoolSize(2);
            pds.setMinPoolSize(2);
            pds.setMaxPoolSize(10);
            
            pds.setValidateConnectionOnBorrow(true);
            
            pds.setSQLForValidateConnection("SELECT 1 FROM DUAL");
        } catch (SQLException e) {
            LOG.error(LogUtil.DB_MARKER, "start connection provider", e);
            throw new MincerException(e.getLocalizedMessage(), e);
        }
        
    }

    public void stop(String... params) {
        
    }

    public Connection getConnection(String... params) throws MincerException {
        
        if(pds == null) {
            LOG.error(LogUtil.DB_MARKER, "connection provider not started");
            throw new MincerException("connection provider not started");
        }
        
        Connection connection = null;
        
        try {
           connection = pds.getConnection(); 
        } catch (SQLException e) {
            LOG.error(LogUtil.DB_MARKER, "error retriving connection", e);
            throw new MincerException(e.getLocalizedMessage(), e);
        }
        
        return connection;
    }

    public void closeConnection(Connection connection, String... params) throws MincerException {
        
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            LOG.error(LogUtil.DB_MARKER, "error closing connection", e);
            throw new MincerException(e.getLocalizedMessage(), e);
        }
    }
    
}
