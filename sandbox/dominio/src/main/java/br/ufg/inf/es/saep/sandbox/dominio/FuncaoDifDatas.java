/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.dominio;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Gilmar
 */
public class FuncaoDifDatas extends Funcao{
    
    private LocalDate dataInicio;
    
    private LocalDate dataFim;
 
    private int configuracao;

    public int getConfiguracao() {
        return configuracao;
    }
    
     /**
     * @param configuracao Esse atributo irá definir qual será o comportamento 
     * do método calculo da classe, pois existem 4 possibilidades: 1 - Diferença
     * entre duas datas em dias, 2 - Diferença entre duas datas em meses, 
     * 3 - Diferença de duas em anos e 4 - Diferença entre duas datas 
     * considerando se houve atividade no mês recorrente ou não
     */
    public void setConfiguracao(int configuracao) {
        if(configuracao > 4 || configuracao < 1)
            throw new IllegalArgumentException();
        this.configuracao = configuracao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public final void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public final void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    
    /**
     * Este método irá retornar a diferença entre duas datas, considerando a
     * configuração da classe. 
     * A diferença, em dias, não considera o primeiro dia, por exemplo: do dia 
     * 22/01/2016 ao 03/02/2016 irá retornar 12 dias.
     * A diferença, em meses, considera apenas períodos inteiros de mês, por
     * exemplo: 12/02/2016 a 07/05/2016 irá retornar 3 meses.
     * A diferença, em anos, considera apenas períodos inteiros de ano, por
     * exemplo: 02/05/2014 a 28/08/2019 irá retornar 5 anos.
     * A diferença, em meses de contagem especial, irá considerar apenas se
     * existe atividade exercida no mês ou não, por exemplo: 31/01/2016 a
     * 01/02/2016 irá retornar 2 meses.
     * @return Período de tempo conforme a configuração da função
     */
    @Override
    public float calculo(){
        float periodo = 0;
        switch(this.getConfiguracao()){
            case 1:
                //Diferença de datas em dias
                periodo = Period.between(this.getDataInicio(), this.getDataFim()).getDays();
                break;
                
            case 2:
                //Diferença de datas em meses
                periodo = Period.between(this.getDataInicio(), this.getDataFim()).getMonths();
                break;
            case 3:
                //Diferença de datas em anos
                periodo = Period.between(this.getDataInicio(), this.getDataFim()).getYears();
                break;
            case 4:
                /**
                 * Diferença de datas em meses considerando se há ocorrência no
                 * mês ou não, mesmo que o mês não esteja completo
                 */
                int difAno = this.getDataFim().getYear() - this.getDataInicio().getYear();
                int mesInicio = this.getDataInicio().getMonthValue();
                int mesFim = this.getDataFim().getMonthValue();
                int meses = 1;
                
                if (difAno > 0)
                    meses += (difAno - 1) * 12;
                
                if (mesInicio > mesFim){
                    meses += (12+mesFim)-mesInicio;
                } else {
                    if (difAno > 0)
                        meses += 12;
                    meses += (mesFim - mesInicio);
                }

                periodo = meses;
                break;
        }
        return periodo;
    }
}
