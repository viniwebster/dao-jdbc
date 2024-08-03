import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(1);
        System.out.println("Find by id: " + seller);
        System.out.println();
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        System.out.println("Find by department: ");

        for (Seller s : list) {
            System.out.println(s);
        }

        System.out.println();
        List<Seller> allSellers = sellerDao.findAll();
        System.out.println("All sellers: ");

        for (Seller s : allSellers) {
            System.out.println(s);
        }

        System.out.println();
        Seller newSeller = new Seller(null, "Antonio", "antonio@gmail.com", new Date(), 3000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id created = " + newSeller.getId());
    }
}