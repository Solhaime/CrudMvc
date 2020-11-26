package SpringBootCrudApp.service.userService;

import SpringBootCrudApp.model.User;

import java.util.List;

public interface UserService {
    void add( User user);
    List<User> listUsers();
    User getUserByUsername(String username);
    public void deleteUserById(Long id);
/*    public void setUserRoleWhereRoleId(Long id);*/
    void updateUserDetails( boolean isActive, Long id );
    public User  getUserById( Long id );
    public void mergeUser(User user);
}
