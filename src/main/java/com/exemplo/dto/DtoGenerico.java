package com.exemplo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DtoGenerico {
    private String tipo;
    private int quantidade;
}
