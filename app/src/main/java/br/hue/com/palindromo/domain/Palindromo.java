package br.hue.com.palindromo.domain;

/**
 * Created by ramsessacol on 16/08/17.
 */

public class Palindromo {
    private String conteudo;

    public Palindromo(String c) {
        this.conteudo = c;
    }

    public boolean ehPalindromo() {
        String invertido  = new StringBuilder( conteudo ).reverse().toString();

        return invertido.equalsIgnoreCase(conteudo);
    }

    public String getConteudo() {
        return conteudo.toLowerCase();
    }
}
