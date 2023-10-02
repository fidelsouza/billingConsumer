package com.cox.oss.billingConsumer.interfaces.endpoint;

import com.cox.oss.billingConsumer.interfaces.dto.BillingDTO;
import com.cox.oss.billingConsumer.services.interfaces.BillingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("billings-consumer/1.0")
public class BillingEndpoint {

    BillingService billingService;

    public BillingEndpoint(@Autowired BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping(value = "/search-all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = " Find all Billings operation ")
    public ResponseEntity<BillingDTO[]> searchAll() {

        BillingDTO[] billings = billingService.searchBillings();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Create Billings Operation")
    public ResponseEntity<BillingDTO> create(@RequestBody BillingDTO billingDTO) {

        ResponseEntity<BillingDTO> billingCreateResponse = billingService.create(billingDTO);

        return billingCreateResponse;
    }

    @PutMapping(value = "/update-total/{number}/{total}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Tag(name = "Update Billing Total")
    public ResponseEntity<BillingDTO> update(@PathVariable Long number, @PathVariable Double total) {

        ResponseEntity<BillingDTO> billingUpdateResponse = billingService.updateTotal(number, total);

        return billingUpdateResponse;
    }

    @DeleteMapping(value = "/remove/{number}")
    @Tag(name = "Remove Billing")
    public ResponseEntity<?> remove(@PathVariable Long number) {

        ResponseEntity<?> billingRemoveResponse = billingService.remove(number);

        return billingRemoveResponse;
    }


}
