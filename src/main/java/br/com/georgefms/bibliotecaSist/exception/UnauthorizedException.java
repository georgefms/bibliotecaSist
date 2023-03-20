package br.com.georgefms.bibliotecaSist.exception;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(){
        super("Usuario não autorizado");
    }
}
