package DAO.roleDao;

import model.Role;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    void addRole(String role);

    Role getRoleById( long id);

    Collection<Role> getAllRoles();

    Role getRoleByName( String role);

    Set<Role> getMultipleRoles( String[] role );
}
