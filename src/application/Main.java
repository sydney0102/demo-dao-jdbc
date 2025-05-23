package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

//CRUD De JDBC, As funções estao dentro das implementações (SellerJDBC e DepartmentJDBC)
//É Necessário estar com o mysql server ligado, e estar com o banco de dados conectado no mysql workbench
//Execute o Script SQL no banco de dados. (Localizado em src/db/database.sql
//
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DB.getConnection();
        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println("----TEST 1 Seller findByID----");
        Seller seller = sellerDAO.findById(2);
        System.out.println(seller);

        System.out.println("\n----TEST 2 Seller findByDepartment----");
        Department dep = new Department(2, null);
        List<Seller> sellersOfDepartment2 = sellerDAO.findByDepartment(dep);
        sellersOfDepartment2.forEach(System.out::println);


        System.out.println("\n----TEST 3 Seller findAll----");
        List<Seller> allSellers = sellerDAO.findAll();
        allSellers.forEach(System.out::println);

        System.out.println("\n----TEST 4 Seller insertSeller----");
        Seller test = new Seller( "test", "<EMAIL>", new Date(System.currentTimeMillis()), 1000.0, new Department(1, null));
        sellerDAO.insert(test);
        List<Seller> testsellerlist = DaoFactory.createSellerDAO().findAll();
        testsellerlist.forEach(System.out::println);
        System.out.println("Inserted a new seller! Id = "+ test.getId());


        System.out.println("\n----TEST 5 Seller deleteId----");
        sellerDAO.deleteId(test.getId());


        System.out.println("\n----TEST 6 Seller update----");
        sellerDAO.update(test, 3 );

        DepartmentDAO depDAO = DaoFactory.createDepartmentDAO();
        System.out.println("----TEST 1 Department findByID----");

        depDAO.insert(new Department(1, "Business"));
        DB.closeConnection();


    }
}
