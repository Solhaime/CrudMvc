package DAO.roleDao;

import model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    EntityManager manager;

    @Override
    public void addRole( String role ) {
        manager.persist(new Role(role));
    }

    @Override
    public Role getRoleById( long id ) {
      return manager.find(Role.class,id);
    }



    @Override
    public Collection<Role> getAllRoles() {
        return manager.createQuery("from Role").getResultList();
    }

    @Override
    public Role getRoleByName( String role ) {
        try {
            return manager.createQuery("select role from Role role where role.name=:name" , Role.class).setParameter("name" , role).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
    @Override
    public Set<Role> getMultipleRoles( String[] role ) {
        try {
            List<Role> name = manager.createQuery("select role from Role role where role.name in (:name)" , Role.class).setParameter("name" , Arrays.asList(role)).getResultList();
            Set<Role> targetSet = new HashSet<>(name);
            return targetSet;
        }catch (NoResultException e){
            return null;
        }
    }

}
