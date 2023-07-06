package stepdefinitions.e2e_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pojos.RoomPojo;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static stepdefinitions.e2e_test.MedunnaRoomStepDefs.roomNumberFaker;

public class DataBaseRoomStepDefs {

    Connection connection;
    Statement statement;
    @Given("connect to database")
    public void connect_to_database() throws SQLException {
        //1. Adım: Connection
        connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");
        //2. Adım: Statement
        statement = connection.createStatement();


    }
    @Then("read room and validate")
    public void read_room_and_validate() throws SQLException {
        //3. Adım: query çalıştır
        String sqlQuery = "SELECT * FROM room WHERE room_number= "+roomNumberFaker;

        ResultSet resultSet = statement.executeQuery(sqlQuery);//Query ile çağırılan data resultSet içerisinde yer alacak.
        resultSet.next(); //next() methodu pointerı sıradaki satıra alır.

        RoomPojo expectedData = new RoomPojo(roomNumberFaker,"SUITE",true,123.0,"Created For End To End Test");


        //Actual Datalar
        String roomType = resultSet.getString("room_type");
        Boolean status = resultSet.getBoolean("status");
        Double price = resultSet.getDouble("price");
        String description = resultSet.getString("description");
        Integer roomNumber = resultSet.getInt("room_Number");

        assertEquals(expectedData.getRoomType(), roomType);
        assertEquals(expectedData.getStatus(), status);
        assertEquals(expectedData.getPrice(), price);
        assertEquals(expectedData.getDescription(), description);
        assertEquals(expectedData.getRoomNumber(), roomNumber);



    }

}
//5432 -->port numarası
//medunna_db_v2 -->database ismi