package com.soccer.team.serviceImpl;
//
//import java.util.List;
//import java.io.*;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.soccer.team.models.Player;
//import com.soccer.team.repository.PlayerRepository;
//import com.soccer.team.service.PlayerService;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Service
//@Data
//public class PlayerServiceImpl implements PlayerService{
//	
//	@Autowired
//	PlayerRepository playerRepository;
//
//	
//	
//
//	@Override
//	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
//		try {
//            Player player = new Player();
//            player.setFirstName(requestMap.get("firstName"));
//            player.setLastName(requestMap.get("lastName"));
//            player.setAge(Integer.parseInt(requestMap.get("age")));
//            player.setGender(requestMap.get("gender"));
//            System.out.println("OKAY : "+player.getFirstName());
//            playerRepository.save(player);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Player Created Successfully");
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create player");
//        }	
//	}
//
//	@Override
//	public List<Player> getAllPlayers() {
//		return playerRepository.findAll();
//	}
//
//	@Override
//	public Optional<Player> getPlayerById(Long id) {
//		return playerRepository.findById(id);
//	}
//
//	@Override
//	]

//
//	@Override
//	public boolean deletePlayer(Long id) {
//		if(playerRepository.existsById(id)) {
//			playerRepository.deleteById(id);
//			return true;
//		}
//		return false;
//		
//	}
//
//}

 //Player Service



import com.soccer.team.repository.PlayerRepository;
import com.soccer.team.service.PlayerService;
import com.soccer.team.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public ResponseEntity<Player> getPlayerById(Long id) {
        return playerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deletePlayer(Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

 