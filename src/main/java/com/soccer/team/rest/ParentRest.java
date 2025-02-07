package com.soccer.team.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.soccer.team.models.Parent;
import com.soccer.team.models.Player;
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(path="/parent")
public interface ParentRest {
	
	
	
	@GetMapping(path="/parents")
    public List<Parent> getAllParents();
    
    @PostMapping(path="/create")
    public Parent createParent(@RequestBody Parent parent);
    
    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long id);
    
    @PostMapping(path="createOrGet")
    public ResponseEntity<Parent> getOrCreateParent(@RequestBody Parent parent);
    
    @PostMapping("/{parentId}/add/players")
    public ResponseEntity<Player> addPlayerToParent(@PathVariable Long parentId, @RequestBody Player player);
    

    @PutMapping("/{parentId}/players")
    public ResponseEntity<?> addOrUpdatePlayer(@PathVariable Long parentId, @RequestBody Player player);
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id);
	 

}
