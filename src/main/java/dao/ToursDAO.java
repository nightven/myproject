package dao;



import model.Tours;

import java.util.Collection;

public interface ToursDAO extends ItemDAO<Tours>{
    public Collection<Tours> getAllbyRegion(int region);

}
