package dao;

import bean.Association;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AssociationDaoImpl implements AssociationDao {
    @Override
    public List<Association> FindAllAssociation() {
        List<Association> associations = new ArrayList<>();

        String sql = "SELECT * FROM association ORDER BY ass_ID desc";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int assid = rs.getInt("ass_ID");//应该与传入参数 id相同
                String name = rs.getString("ass_name");
                float fee = rs.getFloat("fee");
                int level = rs.getInt("level");
                int number = rs.getInt("number");
                int status = rs.getInt("status");

                Association association = new Association(name, assid, fee, number, level, status);
                associations.add(association);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return associations;
    }

    @Override
    public Association FindAssociationByid(int id) {

        Association association = null;
        String sql = "SELECT * FROM association WHERE ass_ID = " + id;
        try (Connection c = DBUtil.getConnection(); Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int assid = rs.getInt("ass_ID");//应该与传入参数 id相同
                String name = rs.getString("ass_name");
                float fee = rs.getFloat("fee");
                int level = rs.getInt("level");
                int number = rs.getInt("number");
                int status = rs.getInt("status");

                association = new Association(name, assid, fee, number, level, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return association;
    }

//    @Override
//    public void UpdataAssociationByid(int id) {
//
//    }
//没有使用逻辑删除，而是直接删除
    @Override
    public void DeleteAssociationByid(int id) {
        String sql = "DELETE FROM association WHERE ass_ID= ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//重载delete方法，status=1意味删除，0为恢复逻辑删除
    @Override
    public void DeleteAssociationByid(int id, int status) {
        String sql="UPDATE association set status= ? where ass_ID= ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,status);
            ps.setInt(2,id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void UpdataAssociationByid(int id, Association association) {
        String sql="UPDATE association set ass_ID= ?,ass_name=?,fee=?,number=?,level=?,status=? WHERE ass_ID=?";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,association.getId());
            ps.setString(2,association.getName());
            ps.setFloat(3, association.getFee());
            ps.setInt(4,association.getNumber());
            ps.setInt(5, association.getLevel());
            ps.setInt(6,association.getStatus());

            ps.setInt(7,id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAssociation(Association association) {
        String sql="INSERT INTO association VALUES(?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(2,association.getId());
            ps.setString(1,association.getName());
            ps.setFloat(3, association.getFee());
            ps.setInt(4,association.getNumber());
            ps.setInt(5, association.getLevel());
            ps.setInt(6,association.getStatus());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

