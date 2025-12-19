// package com.example.demo.controller;

// import com.example.demo.entity.CustomerProfile;
// import com.example.demo.service.CustomerProfileService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/customers")
// @Tag(name = "Customer Profile")
// public class CustomerProfileController {

//     private final CustomerProfileService service;

//     public CustomerProfileController(CustomerProfileService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public CustomerProfile create(@RequestBody CustomerProfile customer) {
//         return service.createCustomer(customer);
//     }

//     @GetMapping("/{id}")
//     public CustomerProfile getById(@PathVariable Long id) {
//         return service.getCustomerById(id);
//     }

//     @GetMapping
//     public List<CustomerProfile> getAll() {
//         return service.getAllCustomers();
//     }

//     @PutMapping("/{id}/tier")
//     public void updateTier(@PathVariable Long id,
//                            @RequestParam String newTier) {
//         service.updateTier(id, newTier);
//     }

//     @PutMapping("/{id}/status")
//     public void updateStatus(@PathVariable Long id,
//                              @RequestParam boolean active) {
//         service.updateStatus(id, active);
//     }

//     @GetMapping("/lookup/{customerId}")
//     public CustomerProfile findByCustomerId(@PathVariable String customerId) {
//         return service.findByCustomerId(customerId);
//     }
// }
