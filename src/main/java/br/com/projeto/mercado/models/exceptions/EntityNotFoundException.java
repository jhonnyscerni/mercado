package br.com.projeto.mercado.models.exceptions;

public class EntityNotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Long id) {
        this(String.format("Não existe um cadastro com código %d", id));
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
