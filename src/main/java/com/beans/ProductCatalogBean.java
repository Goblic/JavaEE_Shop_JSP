/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;


import com.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.sql.DataSource;

/**
 *
 * @author student
 */
@Singleton
public class ProductCatalogBean {

    @Resource(lookup = "jdbc/PostgreDS")
    DataSource ds;

    @PostConstruct
    public void init() {
        System.out.println("ProductCatalogBean.init");
    }

    //     
    // insert into product_category (code, name) values('code1', 'Books')
    // select * from product_category where id = 1
    public Category getCategory(Long id) {
        System.out.println("ProductCatalogBean.getCategory");

        final String q = "select id, code, name, creation_date from product_category where id=?";
        try (Connection c = ds.getConnection();
                PreparedStatement ps = createCategoryStatement(c, q, id);
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                //Long id = rs.getLong(1); 
                String code = rs.getString(2);
                String name = rs.getString(3);
                Date dt = rs.getTimestamp(4);
                // 
                System.out.println("code=" + code);
                System.out.println("name=" + name);
                System.out.println("dt=" + dt);
                return new Category(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static PreparedStatement createCategoryStatement(final Connection c,
            final String q,
            final Long id)
            throws SQLException {
        PreparedStatement ps = c.prepareStatement(q);
        ps.setLong(1, id);
        return ps;
    }

    //select id, code, name, creation_date from product_category 
    public List<Category> getCategories() {
        System.out.println("ProductCatalogBean.getCategories");

        final String q = "select id, code, name, creation_date from product_category order by name";
        final List<Category> list = new ArrayList<>(10);
        // 
        try (Connection c = ds.getConnection();
                PreparedStatement ps = c.prepareStatement(q);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Category(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4)));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return list;
    }

    // 
    public void createCategory(Category category) {
        System.out.println("ProductCatalogBean.createCategory");
        final String q = "insert into product_category(code,name) values (?, ?)";
        // 
        try (Connection c = ds.getConnection();
                PreparedStatement ps = createInsertCategoryStatement(c, q, category);) {
            int resCount = ps.executeUpdate();
            System.out.println("createCategory.resCount=" + resCount);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private static PreparedStatement createInsertCategoryStatement(final Connection c,
            final String q,
            final Category category) throws SQLException {
        PreparedStatement ps = c.prepareStatement(q);
        ps.setString(1, category.getCode());
        ps.setString(2, category.getName());
        return ps;
    }
    
       public void deleteCategory(Category category) {
        System.out.println("ProductCatalogBean.deleteCategory");
        
        final String q = "delete from product_category where code=?";
        // 
        try (Connection c = ds.getConnection();
                PreparedStatement ps = deleteCategoryStatement(c, q, category);) {
            int resDelete = ps.executeUpdate();
            System.out.println("deleteCategory.resDelete=" + resDelete);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    
        private static PreparedStatement deleteCategoryStatement(final Connection c,
            final String q,
            final Category category) throws SQLException {
        PreparedStatement ps = c.prepareStatement(q);
        ps.setString(1, category.getCode());
        return ps;
    }
}
