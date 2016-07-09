/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Logica.Coordenadas;
import javax.swing.JButton;

/**
 *
 * @author mao
 */
public class Boton extends JButton{
    
    Coordenadas cordenada = new Coordenadas();

    public Coordenadas getCordenada() {
        return cordenada;
    }

    public void setCordenada(Coordenadas cordenada) {
        this.cordenada = cordenada;
    }
    
    
    
}
