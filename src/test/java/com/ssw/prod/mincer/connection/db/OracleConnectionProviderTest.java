/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssw.prod.mincer.connection.db;

import com.ssw.prod.mincer.exceptions.MincerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author m.genova
 */
public class OracleConnectionProviderTest {
    
    private static OracleConnectionProvider provider;

    @BeforeClass
    public static void setUpClass() throws Exception {
        provider = new OracleConnectionProvider();
        provider.start();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void createConnectionTest() throws MincerException, SQLException {
        Connection connection = provider.getConnection();
        assertNotNull(connection);
        
        PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM SYSTEMS");
        boolean execute = prepareStatement.execute();
        
        assertTrue(execute);
        
        connection.close();
        assertTrue(connection.isClosed());
    }
}
