package lveapp.fr.retrofitnumbertwo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Maranatha on 03/03/2017.
 */

public class Pays {
    @SerializedName("id")
    private int id;
    @SerializedName("code")
    private String code;
    @SerializedName("alpha2")
    private String alpha2;
    @SerializedName("alpha3")
    private String alpha3;
    @SerializedName("nom_en_gb")
    private String nom_en_gb;
    @SerializedName("nom_fr_fr")
    private String nom_fr_fr;

    public Pays(int id, String code, String alpha2, String alpha3, String nom_en_gb, String nom_fr_fr) {
        this.id = id;
        this.code = code;
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.nom_en_gb = nom_en_gb;
        this.nom_fr_fr = nom_fr_fr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getNom_en_gb() {
        return nom_en_gb;
    }

    public void setNom_en_gb(String nom_en_gb) {
        this.nom_en_gb = nom_en_gb;
    }

    public String getNom_fr_fr() {
        return nom_fr_fr;
    }

    public void setNom_fr_fr(String nom_fr_fr) {
        this.nom_fr_fr = nom_fr_fr;
    }
}

