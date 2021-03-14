package lt.vtmc.Users.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.vtmc.Users.Entity.User;
import lt.vtmc.Users.Repository.UserRepository;

@Service
public class UserService implements IUserService {

	private final UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public List<User> getUsers(int pages, int limit) {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		if (userRepo.findById(id) == null) {
			throw new IllegalStateException("user with ID: " + id + " does not exist");
		} else {
			return userRepo.findById(id);
		}
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		if (userRepo.findById(id) == null) {
			throw new IllegalStateException("user with ID: " + id + " does not exist");
		} else {
			userRepo.deleteById(id);
		}
	}

	@Transactional
	public void updateUser(Long id, String firstName, String lastName, String email, String password) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new IllegalStateException("user with ID: " + id + " does not exist"));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
	}
}
