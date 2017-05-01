package empRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.models.User;

@ComponentScan(basePackages = {"com.dao"})
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
	}

}
