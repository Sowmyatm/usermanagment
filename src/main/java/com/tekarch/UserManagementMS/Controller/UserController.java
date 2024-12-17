package com.tekarch.UserManagementMS.Controller;

import com.tekarch.UserManagementMS.Models.User;
import com.tekarch.UserManagementMS.Repositories.UserRepository;
import com.tekarch.UserManagementMS.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {

    private final UserService userService;


    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    // Get user by ID
//    @GetMapping("/users/{userId}")
//    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
//        Optional<User> user = userRepository.findById(userId);
//
//        if (user.isPresent()) {
//            return ResponseEntity.ok(user.get());
//        } else {
//            return ResponseEntity.notFound().build(); // return 404 if user not found
//        }
//    }

    // Create a new user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    // Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//  Get user by username
    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // Update user
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUserByUserId(@PathVariable Long userId, @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.updateUser(userId, updatedUser));
    }

    // Delete user
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

//    // Get user by ID
//    @GetMapping("/{userId}")
//    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
//        try {
//            User user = userService.getUserById(userId);
//            return ResponseEntity.ok(user);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Get all users by KYC status
//    @GetMapping("/kyc/{status}")
//    public ResponseEntity<List<User>> getUsersByKycStatus(@PathVariable String status) {
//        List<User> users = userService.getUsersByKycStatus(status);
//        return ResponseEntity.ok(users);
//    }
//
//    // Update KYC status
//    @PutMapping("/{userId}/kyc/{status}")
//    public ResponseEntity<User> updateKycStatus(@PathVariable Long userId, @PathVariable String status) {
//        try {
//            User updatedUser = userService.updateKycStatus(userId, status);
//            return ResponseEntity.ok(updatedUser);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Initiate KYC verification
//    @PutMapping("/{userId}/kyc/initiate")
//    public ResponseEntity<User> initiateKyc(@PathVariable Long userId) {
//        User updatedUser = userService.initiateKycVerification(userId);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    // Reject KYC verification
//    @PutMapping("/{userId}/kyc/reject")
//    public ResponseEntity<User> rejectKyc(@PathVariable Long userId) {
//        User updatedUser = userService.rejectKycVerification(userId);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    // Verify KYC
//    @PutMapping("/{userId}/kyc/verify")
//    public ResponseEntity<User> verifyKyc(@PathVariable Long userId) {
//        User updatedUser = userService.verifyKyc(userId);
//        return ResponseEntity.ok(updatedUser);
//    }
//}
}



