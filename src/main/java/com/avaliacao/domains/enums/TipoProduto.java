package com.avaliacao.domains.enums;

public enum TipoProduto {

    COMIDA(0, "COMIDA"), BEBIDA(1, "BEBIDA"), UTENSILIO(2, "UTENSILIO"), ACESSORIO(3, "ACESSORIO"), ARTIGO_PARA_FESTA(4, "ARTIGO_PARA_FESTA");

    private Integer id;
    private String tipoProduto;
    
    private TipoProduto(Integer id, String tipoProduto) {
        this.id = id;
        this.tipoProduto = tipoProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public static TipoProduto toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for(TipoProduto x: TipoProduto.values()) {
            if(id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo de produto inválido!");
    }
}
