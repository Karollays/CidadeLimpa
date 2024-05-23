package br.com.fiap.cidadelimpa.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name ="T_COLETA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Coleta {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_T_COLETA")
    @SequenceGenerator(
            name = "SEQ_T_COLETA",
            sequenceName = "SEQ_T_COLETA",
            allocationSize = 1)
    @Column(name = "id_coleta")
    private Long id;
    @Column(name = "dt_coleta")
    private LocalDate dataColeta;
    @Column(name = "tp_coleta")
    private String tipoColeta;
    @ManyToOne
    @JoinColumn(name = "caminhao_id")
    private Caminhao caminhao;
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
}