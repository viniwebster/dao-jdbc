package model.dao.impl;

import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {
    Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st;
        ResultSet rs;
        try {
             st = conn.prepareStatement("SELECT seller.*,department.Name as DepName " +
                    "FROM seller INNER JOIN department " +
                    "ON seller.DepartmentId = department.Id " +
                    "WHERE seller.Id = ?");

             st.setInt(1, id);
             rs = st.executeQuery();

             if (rs.next()) {
                 Department dep = new Department();
                 dep.setId(rs.getInt("DepartmentId"));
                 dep.setName(rs.getString("DepName"));

                 Seller obj = new Seller();
                 obj.setId(rs.getInt("Id"));
                 obj.setName(rs.getString("Name"));
                 obj.setEmail(rs.getString("Email"));
                 obj.setBirthDate(rs.getDate("BirthDate"));
                 obj.setBaseSalary(rs.getDouble("BaseSalary"));
                 obj.setDepartment(dep);

                 return obj;
             }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
