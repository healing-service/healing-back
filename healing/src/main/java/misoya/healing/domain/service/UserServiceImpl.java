package misoya.healing.domain.service;

import misoya.healing.domain.dto.UserJoinSaveDto;
import misoya.healing.domain.model.User;
import misoya.healing.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void saveUser2(UserJoinSaveDto dto) {
        User user = User.builder()
                .userid(dto.getUserid())
                .password(dto.getPassword())
                .username(dto.getUserName())
                .userRole(dto.getUserRole())
                .build();
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
