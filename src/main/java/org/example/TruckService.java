package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TruckService {
      //create or add
    public void addTruck(Truck truck){
        String sql = "insert into truck (name, model, capacity, driver_name) values (?,?,?,?)";
        try {

            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriverName());

            int update = preparedStatement.executeUpdate();
            System.out.println("row affected" + update);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

   //read
    public Truck getTruckId(int id){
        String sql = "select * from truck where id=?";
        Truck truck = new Truck();

        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));
            }

        }catch (Exception e){
           e.printStackTrace();
        }
        return  truck;
    }

    //update

    public  void updateTruck(Truck truck){
        String sql = "update truck set name = ? , model = ?, capacity = ?, driver_name = ? where id = ?";

        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriverName());
            preparedStatement.setInt(5,truck.getId());

            int update = preparedStatement.executeUpdate();

            System.out.println("row updated" + update);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //get all truck

    public List<Truck> getAllTrucks(){
        String sql = "select * from truck";
        List<Truck> trucks = new ArrayList<>();
        try {

            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Truck truck = new Truck();

                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));

                trucks.add(truck);
            }



        }catch (Exception e){
            e.printStackTrace();
        }
        return trucks;
    }

    //Delete   

    public  void deleteTruck(int id){
         String deleteQuery = "delete from truck where id = ?";

        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

            preparedStatement.setInt(1,id);
           int update = preparedStatement.executeUpdate();

            System.out.println("row deleted" + update);

        }
        catch (Exception e){

        }
    }
}
