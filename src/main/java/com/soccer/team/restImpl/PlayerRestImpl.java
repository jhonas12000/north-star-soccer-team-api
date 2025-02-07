package com.soccer.team.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soccer.team.models.Player;
import com.soccer.team.rest.PlayerRest;
import com.soccer.team.service.PlayerService;


//
//@RestController
//public class PlayerRestImpl implements PlayerRest {
//
//    @Autowired
//    private PlayerService playerService;
//
//    
//
//    @Override
//    public ResponseEntity<String> createPlayer(@RequestBody Map<String, String> requestMap) {
//        try {
//            return playerService.signUp(requestMap);
//        } catch (Exception ex) {
//            return ResponseEntity.status(400).body("Failed to create player");
//        }
//    }
//
//	@Override
//	public ResponseEntity<List<Player>> getAllPlayers() {
//		List<Player> players = playerService.getAllPlayers();
//		
//		if(players.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.ok(players);
//	}
//
//	@Override
//	public ResponseEntity<Player> getPlayerById(Long id) {
//		
//		return playerService.getPlayerById(id)
//				.map(player -> ResponseEntity.ok(player))
//				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//	}
//
//	@Override
//	public ResponseEntity<Player> updatePlayer(Long id, Player updatedPlayer) {
//		return playerService.updatePlayer(id, updatedPlayer)
//				.map(player -> ResponseEntity.ok(player))
//				.orElse(ResponseEntity.notFound().build());
//	}
//
//	@Override
//	public ResponseEntity<Void> deletePlayer(Long id) {
//		boolean isDeleted = playerService.deletePlayer(id);
//		
//		if(isDeleted) {
//			return ResponseEntity.noContent().build();
//		}else {
//			return ResponseEntity.notFound().build();
//		}
//		
//	}
//	
//}


 // Player Rest Controller
//package com.northstarsoccerteam.controllers;



import org.springframework.web.bind.annotation.*;



@RestController
//@RequestMapping("/api/players")
public class PlayerRestImpl implements PlayerRest {

    @Autowired
    PlayerService playerService;

    @Override
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @Override
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @Override
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @Override
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        return playerService.deletePlayer(id);
    }
}



