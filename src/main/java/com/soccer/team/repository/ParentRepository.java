package com.soccer.team.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccer.team.models.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
	
	Optional<Parent> findByEmail(String email);
}


 
  // Parent Repository
//package com.northstarsoccerteam.repositories;
//package com.soccer.team.repository;
//import com.soccer.team.models.Parent;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ParentRepository extends JpaRepository<Parent, Long> {
//}
 
