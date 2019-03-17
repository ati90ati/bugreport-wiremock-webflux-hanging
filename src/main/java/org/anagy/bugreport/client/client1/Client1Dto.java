package org.anagy.bugreport.client.client1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client1Dto {

    private UUID randomId;
    private String number;

}
