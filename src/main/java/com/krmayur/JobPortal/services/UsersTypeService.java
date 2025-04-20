package com.krmayur.JobPortal.services;

import com.krmayur.JobPortal.entity.UsersType;
import com.krmayur.JobPortal.repository.UsersTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;

    @Autowired
    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll()
    {
        return usersTypeRepository.findAll();
    }
}
