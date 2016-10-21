/**
 * Created by Tazy on 10/20/2016.
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        // write your code here

//        Scanner reader = new Scanner(System.in);  // Reading from System.in
//        System.out.println("Enter a Command: ");
//        String process = reader.next(); // Scans the next token of the input as an int.
//        process.trim();

        Dao connection = new Dao(); //Constructing a DAO object

        String process = "retrieve";
        System.out.println(process);
        if (process == "insert") {

            Product product = new Product(222);
            product.setManufacturer("philips");
            product.setType("defibrillator");
            product.setProductionDate("4/5/2013");
            product.setExpiryDate("3/5/2017");
            connection.insertProduct(product);

        } else if (process == "retrieve") {

            List<Product> showResults = new ArrayList<Product>(); //An ArrayList to hold the retrieved data
            showResults = connection.retrieveProduct("philips"); //Retrieval of data
            System.out.println("ID  Type  Manufacturer  Production_Date  Expiry_Date"); //The order of data printed
            int i = 0;
            for (i = 0; i < showResults.size(); i++) { //Printing the retrieved data
                System.out.println(showResults.get(i).getId() + " " + showResults.get(i).getType() + " " +
                        showResults.get(i).getManufacturer() + "   " + showResults.get(i).getProductionDate() + "   " +
                        showResults.get(i).getExpiryDate());
            }

        } else if (process == "delete") {

            connection.deleteProduct(222);

        } else if (process == "update") {

            Product product = new Product(1212);

            product.setManufacturer("philips");
            product.setType("x-ray");
            product.setProductionDate("4/4/2015");
            product.setExpiryDate("3/7/2020");

//            product.setManufacturer("");
//            product.setType("incubator");
//            product.setProductionDate("NULL");
//            product.setExpiryDate("1/4/2017");
            //System.out.println("Almost there!");
            connection.updateProduct(product);

        }
        else
            System.out.println("Command not recognized!");
    }
}
