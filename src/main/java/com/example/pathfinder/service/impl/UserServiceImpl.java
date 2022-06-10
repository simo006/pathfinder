package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.dto.LoginUserDto;
import com.example.pathfinder.model.dto.RegisterUserDto;
import com.example.pathfinder.model.dto.UserSessionDto;
import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.enums.LevelEnum;
import com.example.pathfinder.model.enums.RoleEnum;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(RegisterUserDto registerUserDto) {
        User user = modelMapper.map(registerUserDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setLevel(LevelEnum.BEGINNER);

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(RoleEnum.USER));
        user.setRoles(roles);

        userRepository.save(user);

        saveSessionData(user);

        return true;
    }

    @Override
    public boolean login(LoginUserDto loginUserDto) {
        Optional<User> optionalUser = userRepository.findByUsername(loginUserDto.getUsername());
        if (optionalUser.isPresent() &&
                passwordEncoder.matches(loginUserDto.getPassword(), optionalUser.get().getPassword())) {
            User user = optionalUser.get();

            saveSessionData(user);

            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        currentUser.eraseData();
    }

    @Override
    public boolean isUsernameFree(String username) {
        return !userRepository.existsByUsername(username);
    }

    private void saveSessionData(User user) {
        UserSessionDto userData = modelMapper.map(user, UserSessionDto.class);
        currentUser.updateData(userData);
    }
}
