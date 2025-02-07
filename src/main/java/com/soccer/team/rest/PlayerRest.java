package com.soccer.team.rest;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soccer.team.models.Player;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(path="/player")
public interface PlayerRest {
	
	
	
	@GetMapping(path="/players")
    public List<Player> getAllPlayers();
    
    @PostMapping(path="create")
    public Player createPlayer(@RequestBody Player player);
    
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id);
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id);
		

}
