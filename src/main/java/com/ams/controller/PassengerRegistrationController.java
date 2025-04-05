package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.PassengerRegistration;
import com.ams.entity.User;
import com.ams.repository.UserRepository;
import com.ams.security.JwtTokenUtil;
import com.ams.service.PassengerRegistrationService;

@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerRegistrationController {

    private final PassengerRegistrationService passengerService;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;

    @Autowired
    public PassengerRegistrationController(PassengerRegistrationService passengerService,
                                           JwtTokenUtil jwtTokenUtil,
                                           UserRepository userRepository) {
        this.passengerService = passengerService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }

    // ✅ Register passenger by extracting user ID from token
    @PostMapping("/user/register")
    public PassengerRegistration userRegister(@RequestHeader("Authorization") String authHeader,
                                              @RequestBody PassengerRegistrationinfo passengerInfo) {
        User user = getUserFromToken(authHeader);
        passengerInfo.setUserId(user.getId()); // Set the user ID in the bean
        return passengerService.userRegister(passengerInfo);
    }

    // ✅ Register as admin (userId is expected in the body)
    @PostMapping("/admin/register")
    public PassengerRegistration adminRegister(@RequestHeader("Authorization") String authHeader,
	@RequestBody PassengerRegistrationinfo passengerInfo) {
		User user = getUserFromToken(authHeader);
        passengerInfo.setUserId(user.getId());
        return passengerService.adminRegister(passengerInfo);
    }

    // ✅ Edit passenger details
    @PutMapping("/user/edit/{id}")
    public PassengerRegistration updateUser(@PathVariable Long id,
                                            @RequestBody PassengerRegistration updatedPassenger) {
        return passengerService.updateDetails(id, updatedPassenger);
    }

    // ✅ Get all registered passengers (admin only)
    @GetMapping("/admin/all")
    public List<PassengerRegistration> getAllUsers() {
        return passengerService.getAll();
    }

    // ✅ Get logged-in user's passenger registrations
    @GetMapping("/user/me")
    public List<PassengerRegistration> getMyRecords(@RequestHeader("Authorization") String authHeader) {
        User user = getUserFromToken(authHeader);
        return passengerService.getByUser(user);
    }

    // ✅ Delete by passenger ID
    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        passengerService.deleteById(id);
        return "User with ID " + id + " has been deleted successfully.";
    }

    // ✅ Helper method to extract user from token
    private User getUserFromToken(String authHeader) {
        String token = authHeader.replace("Bearer ", "").trim();
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user;
    }
}
