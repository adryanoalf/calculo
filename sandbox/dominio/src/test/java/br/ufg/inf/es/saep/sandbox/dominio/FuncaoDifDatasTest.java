/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.dominio;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author aluno
 */
public class FuncaoDifDatasTest {

    /**
     * Test of calculo method, of class FuncaoDifDatas.
     */
    @Test
    public void testCalculoDias() {
        FuncaoDifDatas funcaoDifDatas = new FuncaoDifDatas();
        LocalDate dataInicio = LocalDate.of(2016, Month.JANUARY, 22);
        LocalDate dataFim = LocalDate.of(2016, Month.FEBRUARY, 03);
        funcaoDifDatas.setDataInicio(dataInicio);
        funcaoDifDatas.setDataFim(dataFim);
        funcaoDifDatas.setConfiguracao(1);
        
        assertTrue(funcaoDifDatas.calculo() == 12);
    }
    
    @Test
    public void testCalculoMeses() {
        FuncaoDifDatas funcaoDifDatas = new FuncaoDifDatas();
        LocalDate dataInicio = LocalDate.of(2016, Month.FEBRUARY, 12);
        LocalDate dataFim = LocalDate.of(2016, Month.MAY, 28);
        funcaoDifDatas.setDataInicio(dataInicio);
        funcaoDifDatas.setDataFim(dataFim);
        funcaoDifDatas.setConfiguracao(2);
        
        assertTrue(funcaoDifDatas.calculo() == 3);
    }
    
    @Test
    public void testCalculoYears() {
        FuncaoDifDatas funcaoDifDatas = new FuncaoDifDatas();
        LocalDate dataInicio = LocalDate.of(2014, Month.MAY, 2);
        LocalDate dataFim = LocalDate.of(2019, Month.AUGUST, 7);
        funcaoDifDatas.setDataInicio(dataInicio);
        funcaoDifDatas.setDataFim(dataFim);
        funcaoDifDatas.setConfiguracao(3);
        
        assertTrue(funcaoDifDatas.calculo() == 5);
    }
    
    @Test
    public void testCalculoMonthSpecial() {
        FuncaoDifDatas funcaoDifDatas = new FuncaoDifDatas();
        LocalDate dataInicio = LocalDate.of(2016, Month.JANUARY, 31);
        LocalDate dataFim = LocalDate.of(2016, Month.FEBRUARY, 1);
        funcaoDifDatas.setDataInicio(dataInicio);
        funcaoDifDatas.setDataFim(dataFim);
        funcaoDifDatas.setConfiguracao(4);
        
        assertTrue(funcaoDifDatas.calculo() == 2);
    }
}
