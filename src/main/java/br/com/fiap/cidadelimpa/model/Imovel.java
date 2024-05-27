package br.com.fiap.cidadelimpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_IMOVEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Imovel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_T_IMOVEL")
    @SequenceGenerator(
            name = "SEQ_T_IMOVEL",
            sequenceName = "SEQ_T_IMOVEL",
            allocationSize = 1)
    @Column(name = "id_imovel")
    private Long id;
    @Column(name = "nm_imovel")
    private String nome;
    @Column(name = "ds_rua")
    private String rua;
    @Column(name = "ds_bairro")
    private String bairro;
    @Column(name = "lx_reciclavel")
    private Double reciclavel;
    @Column(name = "lx_organico")
    private Double organico;
    @OneToMany(mappedBy = "imovel")
    private List<Morador> moradores = new ArrayList<>();
}