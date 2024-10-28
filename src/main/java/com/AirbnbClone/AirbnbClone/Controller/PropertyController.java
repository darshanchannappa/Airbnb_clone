package com.AirbnbClone.AirbnbClone.Controller;

import com.AirbnbClone.AirbnbClone.Entity.Property;
import com.AirbnbClone.AirbnbClone.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    /**
     *
     *
     * @param property
     * @param UserId
     * @return
     */

    // create a post Mapping

    @PostMapping
    public Property createProperty(@RequestBody Property property,
                                   @RequestParam Long UserId){
        return propertyService.createProperty(property,UserId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id){
        Property property = propertyService.getPropertyById(id);
        return ResponseEntity.ok(property);
    }

    @GetMapping
    public List<Property> getAllProperty(){
        return propertyService.getAllProperty();
    }
}
