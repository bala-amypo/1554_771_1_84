package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "service_entries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
@JoinColumn(name = "vehicle_id")
private Vehicle vehicle;

@ManyToOne
@JoinColumn(name = "garage_id")
private Garage garage;


    @NotBlank
    private String serviceType;

    @NotNull
    private LocalDate serviceDate;

    @NotNull
    @Positive
    private Long odometerReading;

    @NotNull
    @Positive
    private BigDecimal cost;

    @Lob
    @Size(max = 2000)
    private String notes;

    @CreationTimestamp
    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "serviceEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServicePart> parts;

    @OneToMany(mappedBy = "serviceEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VerificationLog> verificationLogs;
}
