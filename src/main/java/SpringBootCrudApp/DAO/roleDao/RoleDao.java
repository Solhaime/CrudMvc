package SpringBootCrudApp.DAO.roleDao;

import SpringBootCrudApp.model.Role;

import java.util.Collection;

public interface RoleDao {
    void addRole(String role);
    Role getRoleById( long id);
    Collection<Role> getAllRoles();
    boolean deleteRoleById(long id);
}
