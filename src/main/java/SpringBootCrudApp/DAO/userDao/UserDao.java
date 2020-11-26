package SpringBootCrudApp.DAO.userDao;

import SpringBootCrudApp.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void addUser( User user );
    User  getUserByUsername(String username);
   /* Optional<User> selectUserByUsername( String username );*/
   public void deleteUserById(Long id);

    void updateUserDetails( boolean isActive, Long id );

    User  getUserById( Long id );

    void mergeUser( User user );
    /* public void setUserRoleWhereRoleId(Long id);*/
}
