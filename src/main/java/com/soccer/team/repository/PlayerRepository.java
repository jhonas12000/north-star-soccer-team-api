package com.soccer.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccer.team.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

}


 // Player Repository
//package com.northstarsoccerteam.repositories;
//
//import com.soccer.team.models.Player;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface PlayerRepository extends JpaRepository<Player, Long> {
//} 
 
