/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.dominio;

import org.joda.time.DateTime;
import org.joda.time.Days;


/**
 *
 * @author Gilmar
 */
public class FuncaoDifDatas extends Funcao{

    private DateTime dataInicio;
    
    private DateTime dataFim;

    public DateTime getDataInicio() {
        return dataInicio;
    }

    public final void setDataInicio(DateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public DateTime getDataFim() {
        return dataFim;
    }

    public final void setDataFim(DateTime dataFim) {
        this.dataFim = dataFim;
    }
    
    public FuncaoDifDatas(String descricao, DateTime dataInicio, 
            DateTime dataFim) {
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setResultado(this.DiferencaDatas() + "");
        this.setDescricao(descricao);
    }
    
    /**
     * Retorna a diferença entre duas datas em dias
     */
    public int DiferencaDatas(){
        return Days.daysBetween(this.dataInicio, this.dataFim).getDays();
    }   
}
