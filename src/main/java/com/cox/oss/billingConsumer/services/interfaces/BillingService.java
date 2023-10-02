package com.cox.oss.billingConsumer.services.interfaces;

import com.cox.oss.billingConsumer.interfaces.dto.BillingDTO;
import org.springframework.http.ResponseEntity;

public interface BillingService {
    BillingDTO[] searchBillings();

    ResponseEntity<BillingDTO> create(BillingDTO billingDTO);

    ResponseEntity<BillingDTO> updateTotal(Long number, Double total);

    ResponseEntity<?> remove(Long number);
}
