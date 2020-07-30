package com.capstone.repository;

import java.util.Scanner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Scanner input = new Scanner(System.in);
	
	
}
