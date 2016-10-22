/**
 * Created by Tazy on 10/20/2016.
 */

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao implements DaoAbstract {

//    private Statement connectDB () throws SQLException {
//        Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");
//        Statement myst = myconn.createStatement();
//        return myst;
//    }

    public void insertProduct (Product product) {
        try{
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");
            PreparedStatement psmt = myconn.prepareStatement("INSERT INTO `store`.`product` " +
                    "(`Product_ID`, `Type`, `Manufacturer`, `Production_Date`, `Expiry_Date`) VALUES (?, ?, ?, ?, ?);");
            psmt.setInt(1, product.getId());
            psmt.setString(2, product.getType());
            psmt.setString(3, product.getManufacturer());
            psmt.setString(4, product.getProductionDate());
            psmt.setString(5, product.getExpiryDate());
            int i = psmt.executeUpdate();
//            if (i > 0) {
//                JOptionPane.showMessageDialog(null, "Product was successfully added");
//            }
//            else {
//                JOptionPane.showMessageDialog(null, "Product was not added");
//            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateProduct (Product product) {
        try{
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");
            PreparedStatement psmt = myconn.prepareStatement("UPDATE `store`.`product` SET `Type` = ?, " +
                    "`Manufacturer` = ?, `Production_Date` = ?, `Expiry_Date` = ? WHERE `product`.`Product_ID` = ?;");
            psmt.setString(1, product.getType());
            psmt.setString(2, product.getManufacturer());
            psmt.setString(3, product.getProductionDate());
            psmt.setString(4, product.getExpiryDate());
            psmt.setInt(5, product.getId());
            int i = psmt.executeUpdate();
//            if (i > 0) {
//                JOptionPane.showMessageDialog(null, "Product was successfully updated");
//            }
//            else {
//                JOptionPane.showMessageDialog(null, "Product was not updated");
//            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void deleteProduct (int id) {
        try{
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");
            PreparedStatement psmt = myconn.prepareStatement("DELETE FROM `store`.`product` WHERE `product`.`Product_ID` = ?");
            psmt.setInt(1, id);
            int i = psmt.executeUpdate();
//            if (i > 0) {
//                JOptionPane.showMessageDialog(null, "Product was successfully deleted");
//            }
//            else {
//                JOptionPane.showMessageDialog(null, "Product was not deleted");
//            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public List<Product>  retrieveProduct (String manufacturer) throws SQLException {
        List<Product> myProducts = new ArrayList<Product>();
        manufacturer = "\""+manufacturer+"\""; //preparing the string to be accepted by SQL
        Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "");
        PreparedStatement psmt = myconn.prepareStatement("SELECT * FROM `product` WHERE `Manufacturer` = "+manufacturer);
        ResultSet myres = psmt.executeQuery();
        while (myres.next()) {
            Product finalResult = new Product(Integer.parseInt(myres.getString("Product_ID")));
            finalResult.setManufacturer(myres.getString("Manufacturer"));
            finalResult.setExpiryDate(myres.getString("Expiry_Date"));
            finalResult.setProductionDate(myres.getString("Production_Date"));
            finalResult.setType(myres.getString("Type"));
            myProducts.add(finalResult);
        }
        return myProducts;
    }
}
