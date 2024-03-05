package tn.esprit.piproject.Controller;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.piproject.Entities.Complaint;
import tn.esprit.piproject.Entities.ComplaintStatus;
import tn.esprit.piproject.Entities.SatisfactionLevel;
import tn.esprit.piproject.Services.IProjectService;


@RestController
@CrossOrigin(origins = "http://192.168.1.121:4200")
@RequestMapping("/api/complaint")
public class ComplaintController {


    private final IProjectService iProjectService;

    public ComplaintController(final IProjectService iProjectService){
        this.iProjectService=iProjectService;

    }


    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaint() {
        List<Complaint> complaints = iProjectService.getAllComplaint();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }
    // Get complaint by id
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable int id) {
        Optional<Complaint> complaint = iProjectService.getComplaintById(id);
        return complaint.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create complaint
    @PostMapping
    public ResponseEntity<Complaint> createComplaint  (@RequestBody Complaint complaint) {
        try {
            Complaint newComplaint = iProjectService.createComplaint(complaint);
            return new ResponseEntity<>(newComplaint, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update complaint
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable int id, @RequestBody Complaint updatedComplaint) {
        Optional<Complaint> optionalComplaint = iProjectService.getComplaintById(id);
        if (optionalComplaint.isPresent()) {
            Complaint complaint = optionalComplaint.get();
            complaint.setDescription(updatedComplaint.getDescription());
            complaint.setTypeRec(updatedComplaint.getTypeRec());
            complaint.setDateComplaint(updatedComplaint.getDateComplaint());
            complaint.setName(updatedComplaint.getName());
            complaint.setLastname(updatedComplaint.getLastname());
            complaint.setEmail(updatedComplaint.getEmail());
            complaint.setStatus(updatedComplaint.getStatus());
            Complaint updated = iProjectService.updateComplaint(complaint);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete complaint
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable int id) {
        iProjectService.deleteComplaint(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ONLY IF REC IS TREATED
    @PutMapping("/give-note/{id}/{note}")
    public ResponseEntity<?> giveNote(@PathVariable int id, @PathVariable String note) throws Exception{
        Complaint c = iProjectService.getComplaintById(id).orElse(null);
        if (c == null) {
            return new ResponseEntity<>(Arrays.asList("Complaint NOT FOUND"), HttpStatus.NOT_FOUND);
        }
        if (!c.getStatus().toString().equals(ComplaintStatus.TREATED.toString())) {
            return new ResponseEntity<>(Arrays.asList("Complaint is Not Treated Yet."), HttpStatus.BAD_REQUEST);
        }else{
            switch (note.toUpperCase(Locale.ROOT)){
                case "VERY SATISFIED":
                    c.setNote(SatisfactionLevel.VERY_SATISFIED);
                    break;

                case "SATISFIED":
                    c.setNote(SatisfactionLevel.SATISFIED);
                    break;

                case "NEUTRAL":
                    c.setNote(SatisfactionLevel.NEUTRAL);
                    break;

                case "NOT SATISFIED":
                    c.setNote(SatisfactionLevel.NOT_SATISFIED);
                    break;

                default: throw new Exception("UNKNOWN SatisfactionLevel !");
            }
            Complaint updated = iProjectService.updateComplaint(c);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

    }





}
