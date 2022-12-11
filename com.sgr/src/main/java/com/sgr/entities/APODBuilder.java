package com.sgr.entities;

public class APODBuilder {
    private String azp;
    private String aud;
    private String sub;
    private String hd;
    private String iat;
    private String emailVerified;
    private String atHash;
    private String alg;
    private String kid;
    private String typ;
    private String email;
    private String scope;
    private String exp;
    private String expiresIn;
    private String accessType;
    private String error;
    private String errorDescription;
    private String sgrToken;
    private Usuario usuario;

    public APODBuilder setAzp(String azp) {
        this.azp = azp;
        return this;
    }

    public APODBuilder setAud(String aud) {
        this.aud = aud;
        return this;
    }

    public APODBuilder setSub(String sub) {
        this.sub = sub;
        return this;
    }

    public APODBuilder setHd(String hd) {
        this.hd = hd;
        return this;
    }

    public APODBuilder setIat(String iat) {
        this.iat = iat;
        return this;
    }

    public APODBuilder setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
        return this;
    }

    public APODBuilder setAtHash(String atHash) {
        this.atHash = atHash;
        return this;
    }

    public APODBuilder setAlg(String alg) {
        this.alg = alg;
        return this;
    }

    public APODBuilder setKid(String kid) {
        this.kid = kid;
        return this;
    }

    public APODBuilder setTyp(String typ) {
        this.typ = typ;
        return this;
    }

    public APODBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public APODBuilder setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public APODBuilder setExp(String exp) {
        this.exp = exp;
        return this;
    }

    public APODBuilder setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public APODBuilder setAccessType(String accessType) {
        this.accessType = accessType;
        return this;
    }

    public APODBuilder setError(String error) {
        this.error = error;
        return this;
    }

    public APODBuilder setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    public APODBuilder setSgrToken(String sgrToken) {
        this.sgrToken = sgrToken;
        return this;
    }

    public APODBuilder setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public APOD createAPOD() {
        return new APOD(azp, aud, sub, hd, iat, emailVerified, atHash, alg, kid, typ, email, scope, exp, expiresIn, accessType, error, errorDescription, sgrToken, usuario);
    }
}