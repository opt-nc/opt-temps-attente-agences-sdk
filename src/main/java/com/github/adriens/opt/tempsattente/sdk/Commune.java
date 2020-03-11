/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.opt.tempsattente.sdk;

/**
 *
 * @author meilie
 */

public enum Commune {
    
    BOULOUPARIS("&q=localiteRefloc:(BOULOUPARIS)"),
    MOINDOU("&q=localiteRefloc:(MOINDOU)"),
    NOUMEA("&q=localiteRefloc:(NOUMEA)"),
    HOUAILOU("&q=localiteRefloc:(HOUAILOU)"),
    KONE("&q=localiteRefloc:(KONE)"),
    KAALA_GOMEN("&q=localiteRefloc:(KAALA-GOMEN)"),
    POUEBO("&q=localiteRefloc:(POUEBO)"),
    THIO("&q=localiteRefloc:(THIO)"),
    TADINE("&q=localiteRefloc:(TADINE)"),
    MONT_DORE("&q=localiteRefloc:(MONT-DORE)"),
    KOUAOUA("&q=localiteRefloc:(KOUAOUA)"),
    POYA("&q=localiteRefloc:(POYA)"),
    BELEP("&q=localiteRefloc:(BELEP)"),
    ILE_DES_PINS("&q=localiteRefloc:(ILE%20AND%20DES%20AND%20PINS)"),
    DUMBEA("&q=localiteRefloc:(DUMBEA)"),
    BOURAIL("&q=localiteRefloc:(BOURAIL)"),
    CANALA("&q=localiteRefloc:(CANALA)"),
    FAYAOUE("&q=localiteRefloc:(FAYAOUE)"),
    POUM("&q=localiteRefloc:(POUM)"),
    TOUHO("&q=localiteRefloc:(TOUHO)"),
    POUEMBOUT("&q=localiteRefloc:(POUEMBOUT)"),
    KOUMAC("&q=localiteRefloc:(KOUMAC)"),
    PAITA("&q=localiteRefloc:(PAITA)"),
    SARRAMEA("&q=localiteRefloc:(SARRAMEA)"),
    LIFOU("&q=localiteRefloc:(LIFOU)%20OR%20localiteRefloc:(WE)"),
    OUEGOA("&q=localiteRefloc:(OUEGOA)"),
    YATE("&q=localiteRefloc:(YATE)"),
    LA_FOA("&q=localiteRefloc:(LA%20AND%20FOA)"),
    HIENGHENE("&q=localiteRefloc:(HIENGHENE)"),
    MARE("&q=localiteRefloc:(MARE)"),
    POINDIMIE("&q=localiteRefloc:(POINDIMIE)"),
    PONERIHOUEN("&q=localiteRefloc:(PONERIHOUEN)"),
    VOH("&q=localiteRefloc:(VOH)");
    
    public final String url;
    
    Commune(String url) {
        this.url = url;
    }

}
