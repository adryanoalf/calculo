/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.saep.sandbox.dominio;

import br.ufg.inf.es.saep.sandbox.dominio.excecoes.CampoExigidoNaoFornecido;

import java.util.List;

/**
 * Uma função é o meio para realizar algumas operações
 * sobre atributos de um avaliável, cujo resultado é
 * atribuído a uma variável que pode fazer parte de
 * uma expressão de uma regra.
 *
 * <p>Por exemplo, a regra que soma todos os dias
 * dos relatos de uma dada classe exige que a diferença
 * em dias entre os atributos identificados por
 * "dataInicio" e "dataFim' seja estabelecida.
 * A função de código 1, que representa a diferença
 * em dias entre essas duas datas pode ser representada
 * por uma instância dessa classe.
 *
 * @see br.ufg.inf.es.saep.sandbox.dominio.regra.Regra
 */
public abstract class Funcao {

    /**
     * Identificador único da função
     */
    private String descricao;
    /**
     * Identificador do resultado da função
     * empregado em uma expressão.
     */
    private String resultado;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Cria uma função.
     *
     * @param resultado Nome da variável que guardará o resultado
     *                  da avaliação da função.
     *
     * @param identificador O identificador único da função.
     */
    public Funcao(final String resultado,
                  final String identificador) {

        if (resultado == null || resultado.isEmpty()) {
            throw new CampoExigidoNaoFornecido("resultado");
        }

        this.resultado = resultado;
        this.descricao = identificador;
    }
}
