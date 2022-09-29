package br.com.emanuelgabrielsousa.consumerapisandboxbb.client.exceptions;

public class RecursoInacessivelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecursoInacessivelException(String mensagem) {
        super(mensagem);
    }
}
