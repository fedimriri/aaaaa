package tn.esprit.piproject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tn.esprit.piproject.Entities.Internship;
import tn.esprit.piproject.Services.IProjectService;
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    @Autowired
    private IProjectService iProjectService;

    // Get all internships
    @GetMapping
    public ResponseEntity<List<Internship>> getAllInternship() {
        List<Internship> internships = iProjectService.getAllinternships();
        return new ResponseEntity<>(internships, HttpStatus.OK);
    }
    // Get internship by id
    @GetMapping("/{id}")
    public ResponseEntity<Internship> getInternshipById(@PathVariable int id) {
        Optional<Internship> internship = iProjectService.getinternshipById(id);
        if (internship.isPresent()) {
            return new ResponseEntity<>(internship.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create internship
    @PostMapping
    public ResponseEntity<Internship> createInternship(@RequestBody Internship internship) {
        try {
            Internship newInternship = iProjectService.createInternship(internship);
            return new ResponseEntity<>(newInternship, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update internship
    @PutMapping("/{id}")
    public ResponseEntity<Internship> updateInternship(@PathVariable int id, @RequestBody Internship internship) {
        Optional<Internship> oldInternship = iProjectService.getinternshipById(id);
        if (oldInternship.isPresent()) {
            internship.setId(id);
            Internship updatedInternship = iProjectService.updateinternship(internship);
            return new ResponseEntity<>(updatedInternship, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete internship
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInternship(@PathVariable int id) {
        iProjectService.deleteinternship(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
