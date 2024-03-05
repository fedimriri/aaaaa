package tn.esprit.piproject.Config;

import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@Log4j2
public class UUIDGenerator {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        log.info("Randomly generated UUID: {}", uuid);
    }
}