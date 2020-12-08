package service.roleService;

import model.Role;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface RoleService {

    void addRole(String role);

    Role getRoleById(long id);

    Collection<Role> getAllRoles();

    Role getRoleByName( String role);

    Set<Role> getMultipleRoles( String[] role );
}
