/**
 * Created by Tazy on 10/20/2016.
 */
import java.sql.SQLException;
import java.util.List;

public interface DaoAbstract {
    public void insertProduct (Product product);
    public void updateProduct (Product product);
    public void deleteProduct (int id);
    public List<Product> retrieveProduct (String manufacturer) throws SQLException;
}
