package service.userService;

import DAO.userDao.UserDao;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.roleService.RoleService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@ComponentScan("DAO")
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void add( User user , String[] roleName ) {
        Arrays.stream(roleName).forEach(x -> user.addRole(x));
        if(user.getAuthorities().isEmpty()) {
            user.setRole(roleService.getRoleByName("USER"));
        } else {
            Set<Role> roles = user.getAuthorities().stream().map(x ->
                    roleService.getRoleByName(x.getAuthority())).collect(Collectors.toSet());
            user.setRoles(roles);
        }
        user.setPassword(encodePassword(user.getPassword()));
        user.setActive(true);
        userDao.addUser(user);
    }
    @Override
    public void add( User user ) {
        user.setPassword(encodePassword(user.getPassword()));
        user.setActive(true);
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


    @Override
    public User getUserById( Long id ) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void mergeUser( User user , String[] roleName, String isActive ) {
        Arrays.stream(roleName).forEach(x -> user.addRole(x));
        if(!isActive.isEmpty()) {
            user.setActive(Boolean.parseBoolean(isActive));
        } else {
            user.setActive(getUserById(user.getId()).isActive());
        }
        if(user.getPassword().isEmpty()) {
            user.setPassword(userDao.getUserById(user.getId()).getPassword());
        } else {
            user.setPassword(encodePassword(user.getPassword()));
        }
        if(user.getAuthorities().isEmpty()) {
            user.setRoles(userDao.getUserById(user.getId()).getRoles());
        } else {
            Set<Role> roles = user.getAuthorities().stream().map(x ->
                    roleService.getRoleByName(x.getAuthority())).collect(Collectors.toSet());
            user.setRoles(roles);
        }
        userDao.mergeUser(user);
    }

    @Transactional
    @Override
    public String encodePassword( String password ) {
        return passwordEncoder.encode(password);
    }

}
