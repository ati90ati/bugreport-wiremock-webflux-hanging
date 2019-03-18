package org.anagy.bugreport.client.client2;

import java.util.UUID;

public class Client2Dto {

    private UUID randomId;
    private String number;

    public Client2Dto() {
    }

    public Client2Dto(final UUID randomId, final String number) {
        this.randomId = randomId;
        this.number = number;
    }

    public UUID getRandomId() {
        return randomId;
    }

    public void setRandomId(final UUID randomId) {
        this.randomId = randomId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

}
