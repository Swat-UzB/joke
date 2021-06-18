package com.example.jokeapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flags {

    @SerializedName("nsfw")
    @Expose
    private Boolean nsfw;
    @SerializedName("religious")
    @Expose
    private Boolean religious;
    @SerializedName("political")
    @Expose
    private Boolean political;
    @SerializedName("racist")
    @Expose
    private Boolean racist;
    @SerializedName("sexist")
    @Expose
    private Boolean sexist;
    @SerializedName("explicit")
    @Expose
    private Boolean explicit;

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    public Boolean getReligious() {
        return religious;
    }

    public void setReligious(Boolean religious) {
        this.religious = religious;
    }

    public Boolean getPolitical() {
        return political;
    }

    public void setPolitical(Boolean political) {
        this.political = political;
    }

    public Boolean getRacist() {
        return racist;
    }

    public void setRacist(Boolean racist) {
        this.racist = racist;
    }

    public Boolean getSexist() {
        return sexist;
    }

    public void setSexist(Boolean sexist) {
        this.sexist = sexist;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

}