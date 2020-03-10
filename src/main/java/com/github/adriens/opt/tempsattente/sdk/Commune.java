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
enum Commune {
    BOULOUPARIS,
    MOINDOU,
    NOUMEA,
    HOUAILOU,
    KONE,
    KAALA_GOMEN,
    POUEBO,
    THIO,
    TADINE,
    MONT_DORE,
    KOUAOUA,
    POYA,
    BELEP,
    ILE_DES_PINS,
    DUMBEA,
    BOURAIL,
    CANALA,
    FAYAOUE,
    POUM,
    TOUHO,
    POUEMBOUT,
    KOUMAC,
    PAITA,
    SARRAMEA,
    LIFOU,
    OUEGOA,
    YATE,
    LA_FOA,
    HIENGHENE,
    MARE, 
    POINDIMIE, 
    PONERIHOUEN, 
    VOH; 

    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(Commune commune) {
        switch (commune) {
            case BOULOUPARIS:
                this.url = "&q=localiteRefloc:(BOULOUPARIS)";
                break;
            case MOINDOU:
                this.url = "&q=localiteRefloc:(MOINDOU)";
                break;
            case NOUMEA:
                this.url = "&q=localiteRefloc:(NOUMEA)";
                break;
            case HOUAILOU:
                this.url = "&q=localiteRefloc:(HOUAILOU)";
                break;
            case KONE:
                this.url = "&q=localiteRefloc:(KONE)";
                break;
            case KAALA_GOMEN:
                this.url = "&q=localiteRefloc:(KAALA-GOMEN)";
                break;
            case POUEBO:
                this.url = "&q=localiteRefloc:(POUEBO)";
                break;
            case THIO:
                this.url = "&q=localiteRefloc:(THIO)";
                break;
            case TADINE:
                this.url = "&q=localiteRefloc:(TADINE)";
                break;
            case MONT_DORE:
                this.url = "&q=localiteRefloc:(MONT-DORE)";
                break;
            case KOUAOUA:
                this.url = "&q=localiteRefloc:(KOUAOUA)";
                break;
            case POYA:
                this.url = "&q=localiteRefloc:(POYA)";
                break;
            case BELEP:
                this.url = "&q=localiteRefloc:(BELEP)";
                break;
            case ILE_DES_PINS:
                this.url = "&q=localiteRefloc:(ILE%20AND%20DES%20AND%20PINS)";
                break;
            case DUMBEA:
                this.url = "&q=localiteRefloc:(DUMBEA)";
                break;
            case BOURAIL:
                this.url = "&q=localiteRefloc:(BOURAIL)";
                break;
            case CANALA:
                this.url = "&q=localiteRefloc:(CANALA)";
                break;
            case FAYAOUE:
                this.url = "&q=localiteRefloc:(FAYAOUE)";
                break;
            case POUM:
                this.url = "&q=localiteRefloc:(POUM)";
                break;
            case TOUHO:
                this.url = "&q=localiteRefloc:(TOUHO)";
                break;
            case POUEMBOUT:
                this.url = "&q=localiteRefloc:(POUEMBOUT)";
                break;
            case KOUMAC:
                this.url = "&q=localiteRefloc:(KOUMAC)";
                break;
            case PAITA:
                this.url = "&q=localiteRefloc:(PAITA)";
                break;
            case SARRAMEA:
                this.url = "&q=localiteRefloc:(SARRAMEA)";
                break;
            case LIFOU:
                this.url = "&q=localiteRefloc:(LIFOU)%20OR%20localiteRefloc:(WE)";
                break;
            case OUEGOA:
                this.url = "&q=localiteRefloc:(OUEGOA)";
                break;
            case YATE:
                this.url = "&q=localiteRefloc:(YATE)";
                break;
            case LA_FOA:
                this.url = "&q=localiteRefloc:(LA%20AND%20FOA)";
                break;
            case HIENGHENE:
                this.url = "&q=localiteRefloc:(HIENGHENE)";
                break;
            case MARE:
                this.url = "&q=localiteRefloc:(MARE)";
                break;
            case POINDIMIE:
                this.url = "&q=localiteRefloc:(POINDIMIE)";
                break;
            case PONERIHOUEN:
                this.url = "&q=localiteRefloc:(PONERIHOUEN)";
                break;
            case VOH: 
                this.url = "&q=localiteRefloc:(VOH)";
                break;
        }
    }

}
