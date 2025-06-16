package org.waterguard.waterguard.tanque.model;


import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    private double latitude;
    private double longitude;
    private String address;
}
