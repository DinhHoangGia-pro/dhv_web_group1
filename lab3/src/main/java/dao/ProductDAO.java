package dao;

import context.DBContext;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public ProductDAO() {
    }

    // ---------------- GET ALL ----------------
    public List<Product> getAllProducts() {

    List<Product> list = new ArrayList<>();

    String sql = """
            SELECT productId,
                   productName,
                   supplierId,
                   categoryId,
                   quantityPerUnit,
                   unitPrice,
                   unitsInStock
            FROM Product
            """;

    try (
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
    ) {

        while (rs.next()) {

            Product p = new Product(
                    rs.getInt("productId"),
                    rs.getString("productName"),
                    rs.getInt("supplierId"),
                    rs.getInt("categoryId"),
                    rs.getString("quantityPerUnit"),
                    rs.getDouble("unitPrice"),
                    rs.getInt("unitsInStock")
            );

            list.add(p);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

   
}