package dao;

import bean.Association;

import java.util.List;

public interface AssociationDao {

    List<Association> FindAllAssociation();

    Association FindAssociationByid(int id);

    //void UpdataAssociationByid(int id);

    void DeleteAssociationByid(int id);

    void DeleteAssociationByid(int id,int status);
    void UpdataAssociationByid(int id,Association association );

    void addAssociation(Association association);
}
