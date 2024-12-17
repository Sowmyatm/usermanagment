package com.tekarch.UserManagementMS.Services;

import com.tekarch.UserManagementMS.Models.User;
import com.tekarch.UserManagementMS.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Update user details
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPasswordHash(updatedUser.getPasswordHash());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setKycStatus(updatedUser.getKycStatus());
        existingUser.setLinkedAccounts(updatedUser.getLinkedAccounts());
        existingUser.setPersonalInfo(updatedUser.getPersonalInfo());
        return userRepository.save(existingUser);
    }

    // Delete user by ID
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
//
//        public User getUserById(Long userId) {
//            Optional<User> user = userRepository.findById(userId);
//            return user.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//        }
//
//        // Get all users with a specific KYC status
//        public List<User> getUsersByKycStatus(String kycStatus) {
//            return userRepository.findByKycStatus(kycStatus);
//        }
//
//        // Update KYC status of a user
//        public User updateKycStatus(Long userId, String newKycStatus) {
//            User user = getUserById(userId);
//            user.setKycStatus(newKycStatus);
//            return userRepository.save(user); // Save the updated user to the database
//        }
//
//        // Initiate KYC verification
//        public User initiateKycVerification(Long userId) {
//            User user = getUserById(userId);
//            user.setKycStatus("under_review"); // Set status to under review
//            return userRepository.save(user);
//        }
//
//        // Reject KYC verification
//        public User rejectKycVerification(Long userId) {
//            User user = getUserById(userId);
//            user.setKycStatus("rejected"); // Set status to rejected
//            return userRepository.save(user);
//        }
//
//        // Verify KYC (manually or automatically)
//        public User verifyKyc(Long userId) {
//            User user = getUserById(userId);
//            user.setKycStatus("verified"); // Set status to verified
//            return userRepository.save(user);
//        }
    }
}


