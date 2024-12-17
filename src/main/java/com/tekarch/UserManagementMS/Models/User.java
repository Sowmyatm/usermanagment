package com.tekarch.UserManagementMS.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String passwordHash;
    private String phoneNumber;
    private String kycStatus;  // e.g., "pending", "verified", etc.

    @ElementCollection
    private List<String> linkedAccounts; // List of linked accounts (e.g., emails, social media)

    @Lob
    private String personalInfo;  // Personal info (could be a JSON or text)
}





