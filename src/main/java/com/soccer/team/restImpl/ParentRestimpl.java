package com.soccer.team.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//mport com.soccer.team.DTO.ParentDTO;
import com.soccer.team.models.Parent;
import com.soccer.team.models.Player;
import com.soccer.team.rest.ParentRest;
import com.soccer.team.service.ParentService;


@RestController
public class ParentRestimpl implements ParentRest {
	
	@Autowired 
	ParentService parentService;

//	@Override
//	public ResponseEntity<List<Parent>> getAllParents() {
//		List<Parent> parents = parentService.getAllParents();
//		
//		if(parents.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.ok(parents);
//	}


	
	 

	@Override
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

	@Override
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.createParent(parent);
    }

	@Override
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

	@Override
    public ResponseEntity<Player> addPlayerToParent(@PathVariable Long parentId, @RequestBody Player player) {
        return parentService.addPlayerToParent(parentId, player);
    }

//	@Override
//    public ResponseEntity<Player> updatePlayer(@PathVariable Long parentId, @RequestBody Player player) {
//        return parentService.updatePlayer(parentId, player);
//    }
	
//	@Override
//    public ResponseEntity<Parent> addOrUpdatePlayer(@PathVariable Long parentId, @RequestBody Player player) {
//        try {
//            Parent updatedParent = parentService.addOrUpdatePlayer(parentId, player);
//            return new ResponseEntity<>(updatedParent, HttpStatus.OK);
//        } catch (IllegalStateException e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
	
	@Override
	public ResponseEntity<?> addOrUpdatePlayer(@PathVariable Long parentId, @RequestBody Player player) {
	    try {
	        Parent updatedParent = parentService.addOrUpdatePlayer(parentId, player);
	        return new ResponseEntity<>(updatedParent, HttpStatus.OK);
	    } catch (IllegalStateException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    } catch (Exception e) {
	        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@Override
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        return parentService.deleteParent(id);
    }

	@Override
	public ResponseEntity<Parent> getOrCreateParent(@RequestBody Parent parent) {
        try {
            Parent savedParent = parentService.getOrCreateParentWithPlayers(parent);
            return new ResponseEntity<>(savedParent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	  

}
