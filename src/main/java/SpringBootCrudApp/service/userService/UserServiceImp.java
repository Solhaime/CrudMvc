package SpringBootCrudApp.service.userService;

import SpringBootCrudApp.DAO.userDao.UserDao;
import SpringBootCrudApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;



    @Transactional
    @Override
    public void add( User user ) {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getUserByUsername( String username ) {
        return userDao.getUserByUsername(username);
    }

    @Transactional
    @Override
    public void deleteUserById( Long id ) {
        userDao.deleteUserById(id);
    }

    @Transactional
    @Override
    public void updateUserDetails( boolean isActive , Long id ) {
        userDao.updateUserDetails(isActive,id);
    }

    @Override
    public User getUserById( Long id ) {
       return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void mergeUser( User user ) {
        userDao.mergeUser(user);
    }

/*    @Override
    public void setUserRoleWhereRoleId( Long id ) {
        userDao.setUserRoleWhereRoleId(id);
    }*/
}
