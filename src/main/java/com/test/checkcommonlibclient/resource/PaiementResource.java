package com.test.checkcommonlibclient.resource;

import com.test.checkcommonlibclient.service.PaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/paiement")
public class PaiementResource {

    private final PaiementService paiementService;

    public PaiementResource(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping
    public ResponseEntity<String> testPaiement() {
        try {
            paiementService.processPaiement();
            return ResponseEntity.ok("Paiement réussi !");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Paiement échoué après retry !");
        }
    }
}
