package br.com.emanuelgabrielsousa.consumerapisandboxbb.exceptionhandler;

import br.com.emanuelgabrielsousa.consumerapisandboxbb.client.exceptions.RecursoInacessivelException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author emanuel.sousa
 */

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    private static final String VALIDACAO_CAMPOS = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

    private static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se "
            + "o problema persistir, entre em contato com o administrador do sistema.";


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Problema.Campo> campos = new ArrayList<Problema.Campo>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            campos.add(new Problema.Campo(nome, mensagem));
        }

        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo(VALIDACAO_CAMPOS);
        problema.setDataHora(LocalDateTime.now());
        problema.setCampos(campos);

        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {

        TipoProblema tipoProblema = TipoProblema.RECURSO_NAO_ENCONTRADO;
        String detalhe = String.format("O recurso %s, que você tentou acessar, é inexistente.", ex.getRequestURL());

        ProblemaResponse.ProblemaResponseBuilder problema = criarProblemaBuilder(status, tipoProblema, detalhe)
                .mensagem(MSG_ERRO_GENERICA_USUARIO_FINAL);

        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }

    @ExceptionHandler(RecursoInacessivelException.class)
    public ResponseEntity<?> recursoInacessivelException(RecursoInacessivelException ex, WebRequest request) {

        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        TipoProblema tipoProblema = TipoProblema.RECURSO_INDISPONIVEL;
        String detalhe = ex.getMessage();

        ProblemaResponse problema = criarProblemaBuilder(status, tipoProblema, detalhe).mensagem(detalhe).build();

        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<?> httpClientErrorException(HttpClientErrorException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        TipoProblema tipoProblema = TipoProblema.ERRO_NEGOCIO;
        String detalhe = ex.getMessage();

        ProblemaResponse problema = criarProblemaBuilder(status, tipoProblema, detalhe).mensagem(detalhe).build();

        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
                                                        HttpStatus status, WebRequest request) {

        if (ex instanceof MethodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatch((MethodArgumentTypeMismatchException) ex, headers, status, request);
        }

        return super.handleTypeMismatch(ex, headers, status, request);
    }


    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                    HttpHeaders headers, HttpStatus status, WebRequest request) {

        TipoProblema problemType = TipoProblema.PARAMETRO_INVALIDO;

        String detail = String.format(
                "O parâmetro de URL '%s' recebeu o valor '%s', "
                        + "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
                ex.getName(), ex.getValue(), Objects.requireNonNull(ex.getRequiredType()).getSimpleName());

        ProblemaResponse problema = criarProblemaBuilder(status, problemType, detail)
                .mensagem(MSG_ERRO_GENERICA_USUARIO_FINAL).build();

        return handleExceptionInternal(ex, problema, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if (body == null) {
            body = ProblemaResponse.builder().timestamp(LocalDateTime.now()).titulo(status.getReasonPhrase())
                    .status(status.value()).mensagem(MSG_ERRO_GENERICA_USUARIO_FINAL).build();
        } else if (body instanceof String) {
            body = ProblemaResponse.builder().timestamp(LocalDateTime.now()).titulo((String) body)
                    .status(status.value()).mensagem(MSG_ERRO_GENERICA_USUARIO_FINAL).build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ProblemaResponse.ProblemaResponseBuilder criarProblemaBuilder(HttpStatus status, TipoProblema tipoProblema,
                                                                          String detalhe) {

        return ProblemaResponse.builder().timestamp(LocalDateTime.now()).status(status.value())
                .tipo(tipoProblema.getUri()).titulo(tipoProblema.getTitulo());
    }
}
