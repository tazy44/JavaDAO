/**
 * Created by Tazy on 10/20/2016.
 */
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        // write your code here

        Scanner reader = new Scanner(System.in);  // Reading from System.in

        Dao connection = new Dao(); //Constructing a DAO object
        boolean terminateProgram = false; //Controlling the flow of the program

        //String process = "retrieve";
        //System.out.println(process);

        while (!terminateProgram) {

            System.out.println("Enter a Command: ");
            System.out.println("1 to Insert..2 to retrieve..3 to delete..4 to update..5 to exit the program");
            int command = reader.nextInt(); // Scans the next token of the input as an int.

            switch (command) {

                default:
                    System.out.println("Wrong input, please select one of the choices provided");
                case 1: //The case of insertion
                    System.out.println("Please enter the ID of the product");
                    int idInsert = reader.nextInt();

                    System.out.println("Please enter the Manufacturer of the product");
                    String ManufacturerInsert = reader.next();

                    System.out.println("Please enter the Type of the product");
                    String typeInsert = reader.next();

                    System.out.println("Please enter the Production date of the product");
                    String productionDateInsert = reader.next();

                    System.out.println("Please enter the Expiry date of the product");
                    String expiryDateInsert = reader.next();


                    Product product = new Product(idInsert);
                    product.setManufacturer(ManufacturerInsert);
                    product.setType(typeInsert);
                    product.setProductionDate(productionDateInsert);
                    product.setExpiryDate(expiryDateInsert);
                    connection.insertProduct(product);
                    System.out.println("Product inserted successfully");

                    break;

                case 2: //The case of retrieval
                    System.out.println("Please enter the manufacturer you want to retrieve its products");
                    String manufacturer = reader.next();
                    List<Product> showResults = new ArrayList<Product>(); //An ArrayList to hold the retrieved data
                    showResults = connection.retrieveProduct(manufacturer); //Retrieval of data
                    System.out.println("ID  Type  Manufacturer  Production_Date  Expiry_Date"); //The order of data printed
                    int i = 0;
                    for (i = 0; i < showResults.size(); i++) { //Printing the retrieved data
                        System.out.println(showResults.get(i).getId() + " " + showResults.get(i).getType() + " " +
                                showResults.get(i).getManufacturer() + "   " + showResults.get(i).getProductionDate() + "   " +
                                showResults.get(i).getExpiryDate());
                    }
                    break;

                case 3: //The case of deletion
                    System.out.println("Please enter the ID of the product you wish to delete");
                    connection.deleteProduct(reader.nextInt());
                    System.out.println("Product deleted successfully");
                    break;

                case 4: //The case of Update
                    System.out.println("Please enter the ID of the product");
                    //int idProvided = reader.nextInt();
                    Product productUpdate = new Product(reader.nextInt());
                    System.out.println("Please enter the Manufacturer of the product");
                    productUpdate.setManufacturer(reader.next());
                    System.out.println("Please enter the Type of the product");
                    productUpdate.setType(reader.next());
                    System.out.println("Please enter the Production date of the product");
                    productUpdate.setProductionDate(reader.next());
                    System.out.println("Please enter the Expiry date of the product");
                    productUpdate.setExpiryDate(reader.next());
                    connection.updateProduct(productUpdate);
                    System.out.println("Product updated succesfully");
                    break;

                case 5: //The case of program termination
                    reader.close();
                    terminateProgram = true;
                    System.out.println("See you later!");
                    break;
            }

//            if (process == "insert") {
//
//                Product product = new Product(222);
//                product.setManufacturer("philips");
//                product.setType("defibrillator");
//                product.setProductionDate("4/5/2013");
//                product.setExpiryDate("3/5/2017");
//                connection.insertProduct(product);
//
//            } else if (process == "retrieve") {
//
//                List<Product> showResults = new ArrayList<Product>(); //An ArrayList to hold the retrieved data
//                showResults = connection.retrieveProduct("philips"); //Retrieval of data
//                System.out.println("ID  Type  Manufacturer  Production_Date  Expiry_Date"); //The order of data printed
//                int i = 0;
//                for (i = 0; i < showResults.size(); i++) { //Printing the retrieved data
//                    System.out.println(showResults.get(i).getId() + " " + showResults.get(i).getType() + " " +
//                            showResults.get(i).getManufacturer() + "   " + showResults.get(i).getProductionDate() + "   " +
//                            showResults.get(i).getExpiryDate());
//                }
//
//            } else if (process == "delete") {
//
//                connection.deleteProduct(222);
//
//            } else if (process == "update") {
//
//                Product product = new Product(1212);
//
//                product.setManufacturer("philips");
//                product.setType("x-ray");
//                product.setProductionDate("4/4/2015");
//                product.setExpiryDate("3/7/2020");
//
////            product.setManufacturer("");
////            product.setType("incubator");
////            product.setProductionDate("NULL");
////            product.setExpiryDate("1/4/2017");
//                //System.out.println("Almost there!");
//                connection.updateProduct(product);
//
//            } else
//                System.out.println("Command not recognized!");
        }
    }
}
