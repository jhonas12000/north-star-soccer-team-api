package com.soccer.team.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.soccer.team.models.Parent;
//import com.soccer.team.DTO.ParentDTO;
//
//
//import lombok.Data;
//
//@Service
//@Data
//public interface ParentService {
//	
//	List<Parent> getAllParents();
//	
//	//public Parent registerParentAndPlayers(ParentDTO parentDTO);
//
//	Parent registerParentAndPlayers(ParentDTO parentDTO);
//	
//
//}

  // Parent Service

import com.soccer.team.models.Parent;
import com.soccer.team.models.Player; 
import com.soccer.team.repository.ParentRepository;
import com.soccer.team.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ParentService {

    
    
    public List<Parent> getAllParents();
    public Parent createParent(Parent parent);
    public ResponseEntity<Parent> getParentById(Long id);
    public Parent getOrCreateParentWithPlayers(Parent parent);
    public ResponseEntity<Player> addPlayerToParent(Long parentId, Player player);
    public ResponseEntity<Player> updatePlayer(Long parentId, Long playerId, Player playerDetails);
    public ResponseEntity<Void> deleteParent(Long id);
    public Parent addOrUpdatePlayer(Long parentId, Player player);
    
}
    
    
    

   
