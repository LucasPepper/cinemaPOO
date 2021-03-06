package br.edu.ifnmg.cinema.entidade;

import java.text.*;
import java.util.ArrayList;
import java.util.HashMap;

import static br.edu.ifnmg.cinema.entidade.SalaCinema.ASSENTO_DISPONIVEL;

public class Sessao{

    private static final int SEGUNDA_FEIRA = 1;
    private static final int TERCA_FEIRA = 2;
    private static final int QUARTA_FEIRA = 3;
    private static final int QUINTA_FEIRA = 4;
    private static final int SEXTA_FEIRA = 5;
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;

    private static final double PRECO_DIA_UTIL_2D = 20.00;
    private static final double PRECO_DIA_UTIL_3D = 25.00;
    private static final double PRECO_FIM_SEMANA_2D = 25.00;
    private static final double PRECO_FIM_SEMANA_3D = 30.00;

    private final int id;
    private final Filme filme;
    private final String exibicao;
    private final String dimensao;
    private final SalaCinema sala;
    private final int dia;
    private final String horario;
    private static int totalSessoes = 0;

    public Sessao(Filme filme, String exibicao, String dimensao, SalaCinema sala, int dia, String horario)
    {
        this.filme = filme;
        this.exibicao = exibicao;
        this.dimensao = dimensao;
        this.sala = sala;
        this.dia = dia;
        this.horario = horario;
        this.incrementarNumeroSessoes();
        this.id = totalSessoes;

    }

    private void incrementarNumeroSessoes() {
        totalSessoes++;
    }

    public int getId() {
        return id;
    }

    public Filme getFilme() {
        return filme;
    }

    public String getExibicao()
    {
        return this.exibicao;
    }

    public String getDimensao()
    {
        return this.dimensao;
    }

    public SalaCinema getSala() {
        return sala;
    }

    public int getDia() {
        return dia;
    }

    public String getHorario() {
        return horario;
    }

    public double getPreco() {

        if (this.getDia() == SEGUNDA_FEIRA ||
                this.getDia() == TERCA_FEIRA ||
                this.getDia() == QUARTA_FEIRA ||
                this.getDia() == QUINTA_FEIRA ||
                this.getDia() == SEXTA_FEIRA){
                    if (this.getDimensao().equals("2D")){
                        return PRECO_DIA_UTIL_2D;
                    }
                    else{
                        return PRECO_DIA_UTIL_3D;
                    }
        } else{
            if (this.getDimensao().equals("2D")){
                return PRECO_FIM_SEMANA_2D;
            } else{
                return PRECO_FIM_SEMANA_3D;
            }
        }

    }

    public void imprimirFilmeDiaHorarioSessao(){
        System.out.println("Filme: " +this.filme.getNome()
                + "\nDia: " + this.getDia()
                + "\nHorário: " + this.getHorario());
    }

}
