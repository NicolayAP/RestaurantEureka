package co.edu.uptc.restaurante.order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sequence {
    @Id
    private String id;
    private long sequence;
}
