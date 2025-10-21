package co.edu.uptc.catalogo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Double price; // Cambiado de Number a Double
    private Long restaurantId; // La clave para conectarse al microservicio Restaurant

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}