/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitagoras.threads;

/**
 *
 * @author user
 */


public class Monitorando {
    
    public void run(){
        System.out.println("Iniciando monitoramento.");
        while(monitorando == true) {
            //verifica se sistema alvo ainda está em execução
            System.out.println("Monitornando.");
            if(th.isInterrupted() == true) {
                System.out.println("Parando monitoramento.");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                monitorando = false;
            }
        }
    }
    
}
