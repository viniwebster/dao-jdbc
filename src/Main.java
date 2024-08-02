import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

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
    }
}