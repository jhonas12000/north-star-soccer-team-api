package com.soccer.team.serviceImpl;

// Parent Service

import com.soccer.team.service.ParentService;

import jakarta.transaction.Transactional;

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
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private PlayerRepository playerRepository;
    
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public ResponseEntity<Parent> getParentById(Long id) {
        return parentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Retrieve parent and players by email, or create a new parent with players.
     */
    //@Override
    public Parent getOrCreateParentWithPlayers(Parent parent) {
        // Check if the parent exists by email
        Optional<Parent> existingParent = parentRepository.findByEmail(parent.getEmail());
        if (existingParent.isPresent()) {
            return existingParent.get(); // Return existing parent with players
        }

        // If not existed, create the new parent and players
        if (parent.getPlayers() != null) {
            parent.getPlayers().forEach(player -> player.setParent(parent)); // Set parent for all players
        }
        if (parent.getRole() == null || parent.getRole().isEmpty()) {
            parent.setRole("USER"); // Set default role if not provided
        }
        
        return parentRepository.save(parent); // Save the new parent and associated players
    }
    
    //@Override
    public ResponseEntity<Player> addPlayerToParent(Long parentId, Player player) {
        Optional<Parent> parentOptional = parentRepository.findById(parentId);
        if (parentOptional.isPresent()) {
            Parent parent = parentOptional.get();
            player.setParent(parent);
            playerRepository.save(player);
            return ResponseEntity.ok(player);
        }
        return ResponseEntity.notFound().build();
    }
    
    //@Override
    public ResponseEntity<Player> updatePlayer(Long parentId, Long playerId, Player playerDetails) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent() && playerOptional.get().getParent().getId().equals(parentId)) {
            Player player = playerOptional.get();
            player.setFirstName(playerDetails.getFirstName());
            player.setLastName(playerDetails.getLastName());
            player.setAge(playerDetails.getAge());
            player.setGender(playerDetails.getGender());
            playerRepository.save(player);
            return ResponseEntity.ok(player);
        }
        return ResponseEntity.notFound().build();
    }
    
    //@Override
    public ResponseEntity<Void> deleteParent(Long id) {
        if (parentRepository.existsById(id)) {
            parentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
//    public Parent addOrUpdatePlayer(Long parentId, Player player) {
//        Parent parent = parentRepository.findById(parentId)
//                .orElseThrow(() -> new IllegalStateException("Parent not found with ID: " + parentId));
//
//        // Update player or add new player
//        player.setParent(parent);
//        playerRepository.save(player);
//
//        return parentRepository.findById(parentId).orElse(null); // Return updated parent details
//    }
    
//    @Transactional
//    public Parent addOrUpdatePlayer(Long parentId, Player player) {
//        Optional<Parent> optionalParent = parentRepository.findById(parentId);
//        if (optionalParent.isEmpty()) {
//            throw new IllegalStateException("Parent with ID " + parentId + " does not exist.");
//        }
//
//        Parent parent = optionalParent.get(); // id = 2  [12, 13, 14] .. <18 player; 3>
//
//        // Check if player exists before updating
//        if (player.getId() != null) {
//            Optional<Player> optionalPlayer = playerRepository.findById(player.getId());
//            if (optionalPlayer.isPresent()) {
//                Player existingPlayer = optionalPlayer.get();
//                if (existingPlayer.getParent().getId() == parent.getId()) {
//                	// Update fields
//                    existingPlayer.setFirstName(player.getFirstName());
//                    existingPlayer.setLastName(player.getLastName());
//                    existingPlayer.setAge(player.getAge());
//                    existingPlayer.setGender(player.getGender());
//                    existingPlayer.setParent(parent);
//                    
//                    System.out.println("YOU THE  "+existingPlayer);
//                    playerRepository.save(existingPlayer);
//                    parentRepository.save(parent);
//                    return parent; // No need to save explicitly, @Transactional commits changes
//                }
//                
//                
//                
//            }
//        }
//
//        // Prevent creating a new player if the player ID exists but wasn't found
//        if (player.getId() != null && !playerRepository.existsById(player.getId())) {
//            throw new IllegalStateException("Player with ID " + player.getId() + " does not exist.");
//        }
//
//        // If no ID, it's a new player
//        player.setParent(parent);
//        parent.getPlayers().add(player); // Add to parent's list to maintain consistency
//        playerRepository.save(player);
//        parentRepository.save(parent);
//        return parent; // Returning parent will ensure the changes persist
//    }
    public Parent addOrUpdatePlayer(Long parentId, Player player) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new IllegalStateException("Parent with ID " + parentId + " does not exist."));

        if (player.getId() != null) {
            Player existingPlayer = playerRepository.findById(player.getId())
                    .orElseThrow(() -> new IllegalStateException("Player with ID " + player.getId() + " does not exist."));
            if (existingPlayer.getParent().getId().equals(parentId)) {
                existingPlayer.setFirstName(player.getFirstName());
                existingPlayer.setLastName(player.getLastName());
                existingPlayer.setAge(player.getAge());
                existingPlayer.setGender(player.getGender());
                existingPlayer.setParent(parent);
                playerRepository.save(existingPlayer);
                return parent; // Transaction commits automatically
            }
        }

        // Create a new player
        player.setParent(parent);
        parent.getPlayers().add(player);
        playerRepository.save(player);

        return parent;
    }
}
//}

//public Optional<Player> updatePlayer(Long id, Player updatedPlayer) {
//  return playerRepository.findById(id).map(existingPlayer -> {
//      existingPlayer.setFirstName(updatedPlayer.getFirstName());
//      existingPlayer.setLastName(updatedPlayer.getLastName());
//      existingPlayer.setGender(updatedPlayer.getGender());
//      existingPlayer.setAge(updatedPlayer.getAge());
//      
//      return playerRepository.save(existingPlayer);
//  });
//}
 
	


