/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.gui;

import javax.swing.JFrame;

/**
 *
 * @author Mony
 */
public class Ventana extends JFrame{
    public Ventana (String titulo, int alto, int ancho){
        setTitle(titulo);
        this.setSize(alto, ancho);
    }
}
