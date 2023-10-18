/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.dominio;

/**
 *
 * @author Mony
 */
public class Caminera {
    private Multa multas[];
    private int ultimaCarga;
    
    public Caminera(int cantidad){
        multas = new Multa[cantidad];
        ultimaCarga = 0;
    }
    
    public boolean registrarMulta(Multa multa){
        boolean aux = false;
        if(ultimaCarga<multas.length){
            multas[ultimaCarga]= multa;
            aux = true;
            ultimaCarga++;
        }
        
        return aux;
    }
    public float calcularTotal(){
        float aux = 0;
        
        //for each:
        for (Multa x : multas) {
            if(x != null){
                aux += x.calcularMonto();
            }
        }
        
        return aux;
    }
    
    
    public int[] contabilizarCodigoMulta (){
        int conteo[] = new int[20];
        int pos;
        
        for (int i = 0; i < multas.length; i++){
            pos = multas[i].getCodigo()-1;
            conteo[pos]++;
        }
        return conteo;
    }
    
    
    public String mostrarMayorCodigo(){
        String aux = null;
        int may, codMay;
        int conteo[] = this.contabilizarCodigoMulta();
        may = conteo[0];
        codMay = 1;
        for (int i = 1; i < conteo.length;i++){
            if (conteo[i]>may){
                may = conteo[i];
                codMay = i + 1;
            }
        }
        aux = "Código de infracción más frecuente: " + codMay + ", con: " + may
                + " actas labradas";
        return aux;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("Multas cargadas:\n");
        
        for (Multa multa : multas) {
            if(multa != null)
                sb.append(multa.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
