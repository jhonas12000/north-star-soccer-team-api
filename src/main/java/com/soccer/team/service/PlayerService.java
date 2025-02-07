package com.soccer.team.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soccer.team.models.Player;

import lombok.Data;

@Service
@Data
public interface PlayerService {
	
//	List<Player> getAllPlayers();
//	
//	ResponseEntity<String> signUp(Map<String, String> requestMap);
//	
//	public Optional<Player> getPlayerById(Long id);
//	
//	public Optional<Player> updatePlayer(Long id, Player updatePlayer);
//	
//	public boolean deletePlayer(Long id);
	
	
	 public List<Player> getAllPlayers();
	 
	 public Player createPlayer(Player player);
	 
	 public ResponseEntity<Player> getPlayerById(Long id);
	  
	 public ResponseEntity<Void> deletePlayer(Long id);
	 
	 
	
	
}


