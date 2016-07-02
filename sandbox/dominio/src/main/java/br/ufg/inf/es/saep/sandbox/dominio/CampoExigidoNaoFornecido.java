/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.saep.sandbox.dominio;

/**
 * Indica situação excepcional ao avaliar uma
 * regra.
 */
public class CampoExigidoNaoFornecido extends RuntimeException {

    public CampoExigidoNaoFornecido(String mensagem) {
        super(mensagem);
    }
}