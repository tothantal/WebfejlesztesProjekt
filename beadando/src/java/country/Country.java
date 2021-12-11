/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package country;

public class Country {
    private Integer countryID;
    private String name;
    private String language;
    private String capital;

    public Country() {}
    
    public Country(Integer countryID, String name, String language, String capital) {
        this.countryID = countryID;
        this.name = name;
        this.language = language;
        this.capital = capital;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
}
