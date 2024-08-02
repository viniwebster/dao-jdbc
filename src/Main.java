import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1, "Books");

        Seller seller = new Seller(25, "Vinicius", "vini@gmail", new Date(), 2000.0, obj);
        System.out.println(seller);
    }
}