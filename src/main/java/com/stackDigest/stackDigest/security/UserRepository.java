package com.stackDigest.stackDigest.security;

import com.stackDigest.stackDigest.beans.database.UserD;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface UserRepository extends JpaRepository<UserD,Integer> {
	UserD findById(int id);
}
