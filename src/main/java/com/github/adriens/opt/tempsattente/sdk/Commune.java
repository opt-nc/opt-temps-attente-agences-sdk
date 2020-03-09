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
    ALL,
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
    WE,
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

    String url;

    public String getUrl() {
        setUrl(this);
        return this.url;
    }

    public void setUrl(Commune commune) {
        switch (commune) {
            case BOULOUPARIS:
                this.url = "&q=pointAdresse:(BOULOUPARIS)%20OR%20localiteRefloc:(BOULOUPARIS)%20OR%20designation:(BOULOUPARIS)";
                break;
            case MOINDOU:
                this.url = "&q=pointAdresse:(MOINDOU)%20OR%20localiteRefloc:(MOINDOU)%20OR%20designation:(MOINDOU)";
                break;
            case NOUMEA:
                this.url = "&q=pointAdresse:(NOUMEA)%20OR%20localiteRefloc:(NOUMEA)%20OR%20designation:(NOUMEA)";
                break;
            case HOUAILOU:
                this.url = "&q=pointAdresse:(HOUAILOU)%20OR%20localiteRefloc:(HOUAILOU)%20OR%20designation:(HOUAILOU)";
                break;
            case KONE:
                this.url = "&q=pointAdresse:(KONE)%20OR%20localiteRefloc:(KONE)%20OR%20designation:(KONE)";
                break;
            case KAALA_GOMEN:
                this.url = "&q=pointAdresse:(KAALA-GOMEN)%20OR%20localiteRefloc:(KAALA-GOMEN)%20OR%20designation:(KAALA-GOMEN)";
                break;
            case POUEBO:
                this.url = "&q=pointAdresse:(POUEBO)%20OR%20localiteRefloc:(POUEBO)%20OR%20designation:(POUEBO)";
                break;
            case THIO:
                this.url = "&q=pointAdresse:(THIO)%20OR%20localiteRefloc:(THIO)%20OR%20designation:(THIO)";
                break;
            case TADINE:
                this.url = "&q=pointAdresse:(TADINE)%20OR%20localiteRefloc:(TADINE)%20OR%20designation:(TADINE)";
                break;
            case MONT_DORE:
                this.url = "&q=pointAdresse:(MONT-D%20OR%20E)%20OR%20localiteRefloc:(MONT-D%20OR%20E)%20OR%20designation:(MONT-D%20OR%20E)";
                break;
            case KOUAOUA:
                this.url = "&q=pointAdresse:(KOUAOUA)%20OR%20localiteRefloc:(KOUAOUA)%20OR%20designation:(KOUAOUA)";
                break;
            case POYA:
                this.url = "&q=pointAdresse:(POYA)%20OR%20localiteRefloc:(POYA)%20OR%20designation:(POYA)";
                break;
            case BELEP:
                this.url = "&q=pointAdresse:(BELEP)%20OR%20localiteRefloc:(BELEP)%20OR%20designation:(BELEP)";
                break;
            case ILE_DES_PINS:
                this.url = "&q=pointAdresse:(ILE%20AND%20DES%20AND%20PINS)%20OR%20localiteRefloc:(ILE%20AND%20DES%20AND%20PINS)%20OR%20designation:(ILE%20AND%20DES%20AND%20PINS)";
                break;
            case DUMBEA:
                this.url = "&q=pointAdresse:(DUMBEA)%20OR%20localiteRefloc:(DUMBEA)%20OR%20designation:(DUMBEA)";
                break;
            case BOURAIL:
                this.url = "&q=pointAdresse:(BOURAIL)%20OR%20localiteRefloc:(BOURAIL)%20OR%20designation:(BOURAIL)";
                break;
            case CANALA:
                this.url = "&q=pointAdresse:(CANALA)%20OR%20localiteRefloc:(CANALA)%20OR%20designation:(CANALA)";
                break;
            case FAYAOUE:
                this.url = "&q=pointAdresse:(FAYAOUE)%20OR%20localiteRefloc:(FAYAOUE)%20OR%20designation:(FAYAOUE)";
                break;
            case POUM:
                this.url = "&q=pointAdresse:(POUM)%20OR%20localiteRefloc:(POUM)%20OR%20designation:(POUM)";
                break;
            case TOUHO:
                this.url = "&q=pointAdresse:(TOUHO)%20OR%20localiteRefloc:(TOUHO)%20OR%20designation:(TOUHO)";
                break;
            case POUEMBOUT:
                this.url = "&q=pointAdresse:(POUEMBOUT)%20OR%20localiteRefloc:(POUEMBOUT)%20OR%20designation:(POUEMBOUT)";
                break;
            case KOUMAC:
                this.url = "&q=pointAdresse:(KOUMAC)%20OR%20localiteRefloc:(KOUMAC)%20OR%20designation:(KOUMAC)";
                break;
            case PAITA:
                this.url = "&q=pointAdresse:(PAITA)%20OR%20localiteRefloc:(PAITA)%20OR%20designation:(PAITA)";
                break;
            case WE:
                this.url = "&q=pointAdresse:(WE)%20OR%20localiteRefloc:(WE)%20OR%20designation:(WE)";
                break;
            case SARRAMEA:
                this.url = "&q=pointAdresse:(SARRAMEA)%20OR%20localiteRefloc:(SARRAMEA)%20OR%20designation:(SARRAMEA)";
                break;
            case LIFOU:
                this.url = "&q=pointAdresse:(LIFOU)%20OR%20localiteRefloc:(LIFOU)%20OR%20designation:(LIFOU)";
                break;
            case OUEGOA:
                this.url = "&q=pointAdresse:(OUEGOA)%20OR%20localiteRefloc:(OUEGOA)%20OR%20designation:(OUEGOA)";
                break;
            case YATE:
                this.url = "&q=pointAdresse:(YATE)%20OR%20localiteRefloc:(YATE)%20OR%20designation:(YATE)";
                break;
            case LA_FOA:
                this.url = "&q=pointAdresse:(LA%20AND%20FOA)%20OR%20localiteRefloc:(LA%20AND%20FOA)%20OR%20designation:(LA%20AND%20FOA)";
                break;
            case HIENGHENE:
                this.url = "&q=pointAdresse:(HIENGHENE)%20OR%20localiteRefloc:(HIENGHENE)%20OR%20designation:(HIENGHENE)";
                break;
            case MARE:
                this.url = "&q=pointAdresse:(MARE)%20OR%20localiteRefloc:(MARE)%20OR%20designation:(MARE)";
                break;
            case POINDIMIE:
                this.url = "&q=pointAdresse:(POINDIMIE)%20OR%20localiteRefloc:(POINDIMIE)%20OR%20designation:(POINDIMIE)";
                break;
            case PONERIHOUEN:
                this.url = "&q=pointAdresse:(PONERIHOUEN)%20OR%20localiteRefloc:(PONERIHOUEN)%20OR%20designation:(PONERIHOUEN)";
                break;
            case VOH:
                this.url = "&q=pointAdresse:(VOH)%20OR%20localiteRefloc:(VOH)%20OR%20designation:(VOH)";
                break;
        }
    }
}
