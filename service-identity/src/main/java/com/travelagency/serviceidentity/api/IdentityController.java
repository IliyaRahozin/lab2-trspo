package com.travelagency.serviceidentity.api;

import com.travelagency.serviceidentity.repo.model.Identity;
import com.travelagency.serviceidentity.service.IdentityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.criteria.CriteriaBuilder;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public final class IdentityController {

    private final IdentityService identityService;

    // getAllUsers
    @GetMapping
    public ResponseEntity<List<Identity>> index() {
        final List<Identity> users = identityService.fetchAll();
        return ResponseEntity.ok(users);
    }

    // getUserById
    @GetMapping("/{id}")
    public ResponseEntity<Identity> getById(@PathVariable long id) {
        try {
            Identity user = identityService.getUserById(id);
            return ResponseEntity.ok(user);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Create User
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.travelagency.serviceidentity.api.dto.Identity user){
        final String firstname = user.getFirstname();
        final String lastname = user.getLastname();
        final String email = user.getEmail();
        final String telNumber = user.getTelNumber();
        final Integer age = user.getAge();
        final String password = user.getPassword();
        final long id = identityService.createUser(firstname, lastname, email, telNumber, age, password);
        final String location = String.format("/users/" + id);

        return ResponseEntity.created(URI.create(location)).build();
        // 201 status code created() URI location - location resours'a kotoriy sozdadim
    }

    // Update user info
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.travelagency.serviceidentity.api.dto.Identity user){
        final String firstname = user.getFirstname();
        final String lastname = user.getLastname();
        final String email = user.getEmail();
        final String telNumber = user.getTelNumber();
        final Integer age = user.getAge();
        final String password = user.getPassword();

        try {
            identityService.updateUser(id, firstname, lastname, email, telNumber, password, age);
            return ResponseEntity.noContent().build();
        }catch(IllegalArgumentException e){
            return ResponseEntity.notFound().build();

        }
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        identityService.deleteUser(id);
        return  ResponseEntity.noContent().build();
    }


}
