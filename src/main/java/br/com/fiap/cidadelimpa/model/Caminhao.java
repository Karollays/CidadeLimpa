package br.com.fiap.cidadelimpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "T_CAMINHAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Caminhao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_T_CAMINHAO")
    @SequenceGenerator(
            name = "SEQ_T_CAMINHAO",
            sequenceName = "SEQ_T_CAMINHAO",
            allocationSize = 1)
    @Column(name = "id_caminhao")
    private Long id;
    @Column(name = "ds_registro")
    private String registro;
    @Column(name = "qt_capacidade")
    private Double capacidade;
}