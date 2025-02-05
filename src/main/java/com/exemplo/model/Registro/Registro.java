package com.exemplo.model.Registro;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Registro {

    private Long id;
    private String tipoAcao;
    private String descricao;
    private Long pessoaId;
    private Date dataAcao;

    public Registro() {
    }

    public Registro(String tipoAcao, String descricao, Long pessoaId, Date dataAcao) {
        this.tipoAcao = tipoAcao;
        this.descricao = descricao;
        this.pessoaId = pessoaId;
        this.dataAcao = dataAcao;
    }
}
