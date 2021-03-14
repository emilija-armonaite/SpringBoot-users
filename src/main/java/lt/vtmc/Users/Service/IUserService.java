package lt.vtmc.Users.Service;

import java.util.List;
import java.util.Optional;

import lt.vtmc.Users.Entity.User;

public interface IUserService {
	List<User> getUsers(int pages, int limit);

	Optional<User> getUserById(Long id); 

	User createUser(User user); 

	void deleteUser(Long id);

	void updateUser(Long id, String firstName, String lastName, String email, String password);
}
