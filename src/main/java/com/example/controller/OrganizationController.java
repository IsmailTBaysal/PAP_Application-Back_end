package com.example.controller;

import com.example.model.Organization;
import com.example.model.User;
import com.example.repository.OrganizationRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/org")
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;


    @GetMapping("/all")
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }


    @GetMapping("/count")
    public ResponseEntity<?> getOrganizationsCount() {

        Long count = organizationRepository.count();

        int c = count.intValue();
        String message = "";
        message += "Organizations count is: " + c;

        if (c <= 0){
            message = "No Organizations";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }


    @GetMapping("/searchby/name/{name}")
    public ResponseEntity<?> getOrganizationsByName(@PathVariable(value = "name") String name) {

        List<Organization> organizations = organizationRepository.findByNameIgnoreCase(name);

        if (organizations.isEmpty()){
            String message = "No organizations found with the name: " + name;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(organizations);
    }


    @GetMapping("/searchby/zip/{postalcode}")
    public ResponseEntity<?> getOrganizationsByPostalCode(@PathVariable(value = "postalcode") String postalCode) {

        List<Organization> organizations = organizationRepository.findBypostalCode(postalCode);

        if (organizations.isEmpty()){
            String message = "No organizations found with the postalcode: " + postalCode;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(organizations);
    }


    @GetMapping("/searchby/countryid/{countryid}")
    public ResponseEntity<?> getOrganizationsByCountryId(@PathVariable(value = "countryid") int countryId) {

        List<Organization> organizations = organizationRepository.findBycountryId(countryId);

        if (organizations.isEmpty()){
            String message = "No organizations found with the countryid: " + countryId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(organizations);
    }


    @GetMapping("/searchby/id/{id}")
    public ResponseEntity<Organization> getorganizationById(@PathVariable(value = "id") Long organizationId)
            throws ResourceNotFoundException {

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found for this id: " + organizationId));
        return ResponseEntity.ok().body(organization);
    }


    @PostMapping("/add")
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {

        Organization savedOrganization = organizationRepository.save(organization);

        return ResponseEntity.created(null).body(savedOrganization);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable(value = "id") Long organizationId,
                                                           @RequestBody Organization organizationDetails) throws ResourceNotFoundException {

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found for this id: " + organizationId));

        organization.setName(organizationDetails.getName());
        organization.setAddress1(organizationDetails.getAddress1());
        organization.setAddress2(organizationDetails.getAddress2());
        organization.setAddress3(organizationDetails.getAddress3());
        organization.setCity(organizationDetails.getCity());
        organization.setpostalCode(organizationDetails.getpostalCode());
        organization.setfirstName(organizationDetails.getfirstName());
        organization.setmiddleName(organizationDetails.getmiddleName());
        organization.setlastName(organizationDetails.getlastName());
        organization.setmobilePhone(organizationDetails.getmobilePhone());
        organization.setworkPhone(organizationDetails.getworkPhone());
        organization.sethomePhone(organizationDetails.gethomePhone());
        organization.setEmail(organizationDetails.getEmail());
        organization.setcountryId(organizationDetails.getcountryId());
        organization.setstateId(organizationDetails.getstateId());
        organization.setstatusId(organizationDetails.getstatusId());
        organization.setcreatedOn(organizationDetails.getcreatedOn());
        organization.setcreatedBy(organizationDetails.getcreatedBy());
        organization.setmodifiedOn(organizationDetails.getmodifiedOn());
        organization.setmodifiedBy(organizationDetails.getmodifiedBy());
        organization.setrowVersion(organizationDetails.getrowVersion());

        final Organization updatedOrganization = organizationRepository.save(organization);
        return ResponseEntity.ok(updatedOrganization);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteOrganization(@PathVariable(value = "id") Long organizationId)
            throws ResourceNotFoundException {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found for this id: " + organizationId));

        organizationRepository.delete(organization);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted Organization: " + organizationId, Boolean.TRUE);
        return response;
    }
}