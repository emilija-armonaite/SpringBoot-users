package lt.vtmc.Users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.vtmc.Users.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
