package user;

import java.util.List;
import java.util.Map;

public interface UserService {
    String addUsers();
    String join(User user);
    String login(User user);
    User findUserById(String username);
    String updatePassword(User user);
    String deleteUser(String username);
    List<?> getUserList();
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    String countUsers();

    Map<String, ?> getUserMap();
}