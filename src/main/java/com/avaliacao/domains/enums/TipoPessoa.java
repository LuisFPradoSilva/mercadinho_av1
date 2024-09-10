package com.avaliacao.domains.enums;

public enum TipoPessoa {

    ADMIN(0, "ROLE_ADMIN"), FUNCIONARIO(1, "ROLE_FUNCIONARIO"), CLIENTE(2, "CLIENTE");

    private Integer id;
    private String tipoPessoa;
    
    private TipoPessoa(Integer id, String tipoPessoa) {
        this.id = id;
        this.tipoPessoa = tipoPessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public static TipoPessoa toEnum(Integer id) {

        if(id == null) {
            return null;
        }

        for(TipoPessoa x: TipoPessoa.values()) {
            if(id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo de pessoa inválida");
    }
}
