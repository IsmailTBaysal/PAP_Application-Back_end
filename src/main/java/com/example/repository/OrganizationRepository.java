package com.example.repository;

import com.example.model.Organization;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
    List<Organization> findByNameIgnoreCase(String Name);

    List<Organization> findBypostalCode(String postalCode);

    List<Organization> findBycountryId(int countryId);
}