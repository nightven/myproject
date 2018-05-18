package facades;

import dao.daoImpl.CountryDatabaseDAO;
import model.Country;

import java.util.List;

public class CountryFacade {

    CountryDatabaseDAO countryDb = new CountryDatabaseDAO();

    public boolean createCountry(Country country){
        return countryDb.create(country);
    }

    public Country getCountryId(int countryId){
        return countryDb.getById(countryId);
    }

    public List<Country> getAllCountry(){
         return countryDb.getAll();
    }

    public boolean updateCountry(Country country){
        return countryDb.update(country);
    }

    public boolean deleteCountry(Country country){
        return countryDb.delete(country);
    }
}
