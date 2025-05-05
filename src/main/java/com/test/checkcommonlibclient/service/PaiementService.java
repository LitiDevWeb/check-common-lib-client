package com.test.checkcommonlibclient.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
public class PaiementService {

    @RetryOnFailure(maxAttempts = 3, delayMs = 200, include = {IOException.class})
    public void processPaiement() throws IOException {
        System.out.println("Traitement du paiement...");
        if (new Random().nextBoolean()) {
            throw new IOException("Échec simulé !");
        }
    }
}
