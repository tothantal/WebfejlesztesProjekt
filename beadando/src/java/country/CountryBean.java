/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package country;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CountryBean implements Serializable {
    
    private List<Country> countries;

    public List<Country> getCountries() {
        return this.countries;
    }

    public void setCountries() throws SQLException {
        List<Country> cs = new ArrayList<Country>();
        String url = "jdbc:derby://localhost:1527/countrydb;create=true";
        String query = "SELECT * FROM country";
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
         
        
        try {
            
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            
            /*
            String sql = "CREATE TABLE COUNTRY" +
                    "(countryid INTEGER not NULL, " +
                    "name VARCHAR(255), " +
                    "language VARCHAR(255), " +
                    "capital VARCHAR(255), " +
                    "PRIMARY KEY (countryid))";
            statement.executeUpdate(sql);
            */
            
            /*
             sql = "INSERT INTO COUNTRY VALUES (1, 'Hungary', 'Hungarian', 'Budapest')";
             statement.executeUpdate(sql);
             sql = "INSERT INTO COUNTRY VALUES (2, 'Germany', 'German', 'Berlin')";
             statement.executeUpdate(sql);
             sql = "INSERT INTO COUNTRY VALUES (3, 'France', 'French', 'Paris')";
             statement.executeUpdate(sql);
             sql = "INSERT INTO COUNTRY VALUES (4, 'Romania', 'Romanian', 'Bucharest')";
             statement.executeUpdate(sql);
             sql = "INSERT INTO COUNTRY VALUES (5, 'Austria', 'German', 'Vienna')";
             statement.executeUpdate(sql);
            */

            query = "SELECT * FROM country";
            result = statement.executeQuery(query);
            
            
            
            while (result.next()) {
                
                Country c = new Country();
                
                c.setCountryID(result.getInt("COUNTRYID"));
                c.setName(result.getString("NAME"));
                c.setLanguage(result.getString("LANGUAGE"));
                c.setCapital(result.getString("CAPITAL"));
                
                cs.add(c);
                
            }
            
        } catch (SQLException e) {
           System.out.println(e);
        }
        
        this.countries = cs;
    }
    
    public int getID(int id) {
        return this.countries.get(id).getCountryID();
    }
    
    public String getCapital(int id) {
        return this.countries.get(id).getCapital();
    }
    
    public String getName(int id) {
        return this.countries.get(id).getName();
    }
    
    public String getLanguage(int id) {
        return this.countries.get(id).getLanguage();
    }
}
