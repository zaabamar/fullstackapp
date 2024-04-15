package com.Pfa_project.fullstackapp.repsitory;

import com.Pfa_project.fullstackapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
