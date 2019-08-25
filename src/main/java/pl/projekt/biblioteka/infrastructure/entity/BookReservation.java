package pl.projekt.biblioteka.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BookReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String reservedBy;


}
