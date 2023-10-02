package com.cox.oss.billingConsumer.services;

import com.cox.oss.billingConsumer.interfaces.dto.BillingDTO;
import com.cox.oss.billingConsumer.services.interfaces.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class BillingServiceImpl implements BillingService {
    private static Logger LOGGER = LoggerFactory.getLogger(BillingServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${billingsURL}")
    private String billingsURL;
    @Value("${createBillingsURL}")
    private String createBillingsURL;
    @Value("${updateTotalBillingsURL}")
    private String updateTotalBillingsURL;
    @Value("${removeBilling}")
    private String removeBilling;

    @Override
    public BillingDTO[] searchBillings() {
        var billings = restTemplate.getForObject(billingsURL, BillingDTO[].class);
        return billings;
    }

    @Override
    public ResponseEntity<BillingDTO> create(BillingDTO billingDTO) {
        HttpEntity<BillingDTO> request =
                new HttpEntity<BillingDTO>(
                        billingDTO);

        try {
            ResponseEntity<BillingDTO> billingCreateResponse =
                    restTemplate
                            .exchange(createBillingsURL,
                                    HttpMethod.POST,
                                    request,
                                    BillingDTO.class);
            LOGGER.info("Billing(number) was created successfully: " + billingCreateResponse.getBody().getNumber());
            return billingCreateResponse;
        } catch (Exception e) {
            LOGGER.error("Billing creation was unsuccessful", e);
            return new ResponseEntity<>(null);
        }

    }

    @Override
    public ResponseEntity<BillingDTO> updateTotal(Long number, Double total) {

        try {
            String url = updateTotalBillingsURL + "/" + number + "/" + total;
            ResponseEntity<BillingDTO> billingUpdateResponse =
                    restTemplate
                            .exchange(url,
                                    HttpMethod.PUT,
                                    null,
                                    BillingDTO.class);
            LOGGER.info("Billing(number) was updated successfully: " + billingUpdateResponse.getBody().getNumber());
            return billingUpdateResponse;
        } catch (Exception e) {
            LOGGER.error("Billing update was unsuccessful", e);
            return new ResponseEntity<>(null);
        }
    }

    @Override
    public ResponseEntity<?> remove(Long number) {

        try {


            String url = removeBilling + "/" + number;
            ResponseEntity<?> billingRemoveResponse =
                    restTemplate
                            .exchange(url,
                                    HttpMethod.DELETE,
                                    null,
                                    BillingDTO.class);
            LOGGER.info("Billing(number) was deleted successfully: " + number);
            return billingRemoveResponse;
        } catch (Exception e) {
            LOGGER.error("Billing delete was unsuccessful", e);
            return new ResponseEntity<>(null);
        }
    }
}
