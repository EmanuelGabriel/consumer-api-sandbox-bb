package br.com.emanuelgabrielsousa.consumerapisandboxbb.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaInforAdicionalResponseDTO {

    private String codigoInformacaoAdicional;
    private String textoInformacaoAdicional;

}
