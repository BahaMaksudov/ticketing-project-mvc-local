package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.finAll();
    }

    @Override
    public void deleteById(String id) {

        super.deleteById(id);

    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(),object);
    }


    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.finAll().stream().filter(user -> user.getRole().getId() == 2).collect(Collectors.toList());
    }
}