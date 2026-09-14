package pl.aviation.flight_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "aircraft_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AircraftType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4)
    private String typeCode;

    @Column(nullable = false, length = 100)
    private String manufacturer;

    @Column(nullable = false, length = 100)
    private String model;

    @Column(nullable = false)
    private Integer passengerCapacity;

    @Column(nullable = false)
    private Integer range;

    @CreatedDate
    @Column(updatable = false,  nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
