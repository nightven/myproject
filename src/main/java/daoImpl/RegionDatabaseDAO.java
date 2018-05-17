package daoImpl;


import Util.DBUtil;
import dao.RegionDAO;
import model.Region;

import java.util.Collection;

public class RegionDatabaseDAO  implements RegionDAO {


    public RegionDatabaseDAO() {
    }

    @Override
    public boolean create(Region model) {
        return false;
    }

    @Override
    public Region getById(int id) {
        return null;
    }

    @Override
    public Collection<Region> getAll() {
        return null;
    }

    @Override
    public boolean update(Region model) {
        return false;
    }

    @Override
    public boolean delete(Region model) {
        return false;
    }


//    @Override
//    public void insertRegion(Region region) throws SQLException {
//        String sql = "INSERT INTO region(region_id, region) VALUES (?, ?)";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql) ) {
//            preparedStatement.setInt(1, region.getRegionID());
//            preparedStatement.setInt(2,region.getRegion());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(connection != null)
//                connection.close();
//        }
//
//    }
//
//    @Override
//    public void deleteRegion(Region region) {
//        String sql ="DELETE FROM region WHERE region_id=?";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setInt(1,region.getRegionID());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public Region findRegionID(int id) throws SQLException {
//        String sql="SELECT region_id,region FROM region WHERE region_id=?";
//        Region region = new Region();
//        try(PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
//            preparedStatement.setInt(1,id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            region.setRegionID(resultSet.getInt("region_id"));
//            region.setRegion(resultSet.getInt("region"));
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(connection != null)
//                connection.close();
//        }
//        return region;
//    }
//
//    @Override
//    public Collection<Region> getRegionAll() throws SQLException {
//        String sql ="SELECT region_id, region FROM region";
//        Collection<Region>regionsList = new ArrayList<>();
//        try(Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()){
//                Region region = new Region();
//                region.setRegionID(resultSet.getInt("region_id"));
//                region.setRegion(resultSet.getInt("region"));
//                regionsList.add(region);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(connection != null)
//                connection.close();
//        }
//        return regionsList;
//    }
//
//    @Override
//    public void updateRegion(Region region) throws SQLException {
//        String sql = "UPDATE region SET region=? WHERE region_id=?";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setInt(1, region.getRegion());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(connection !=null)
//                connection.close();
//        }
//
//    }
}
