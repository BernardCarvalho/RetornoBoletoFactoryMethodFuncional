/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manoelcampos.retornoboleto;

import java.util.function.Function;

/**
 *
 * @author aluno
 */
public final class EstrategiaBoletoFactory {
    
    private EstrategiaBoletoFactory(){}
    
    public static Function<String[], Boleto> newStrategy(String nomeArquivo){
       
        if(nomeArquivo.contains("banco-brasil"))
            return LeituraRetorno::processarLinhaBancoBrasil;
        if(nomeArquivo.contains("bradesco"))
            return LeituraRetorno::processarLinhaBancoBradesco;
        
        throw new UnsupportedOperationException("Banco não suportado.");
    }    
}
