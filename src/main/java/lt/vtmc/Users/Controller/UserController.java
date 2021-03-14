package lt.vtmc.Users.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import lt.vtmc.Users.Entity.User;
import lt.vtmc.Users.Service.UserService;

@RestController
@RequestMapping(path = "api/users")

public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	@ApiOperation(value = "Get users", notes = "Returns registered users.")
	public List<User> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit) {
		return userService.getUsers(page, limit);
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Get user by ID", notes = "Returns user by ID.")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create user")
	public void createNewUser(@Valid @RequestBody User user) {
		userService.createUser(user);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete user by ID")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}

	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Update user by ID", notes = "Returns updated user info.")
	public void updateUser(@PathVariable("id") Long id, @RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) String email,
			@RequestParam(required = false) String password) {
		userService.updateUser(id, firstName, lastName, email, password);
	}

	// GET /api/users
	// GET /api/users/{id}
	// POST /api/users
	// DELETE /api/users/{id}
	// PUT /api/users/{id}
}