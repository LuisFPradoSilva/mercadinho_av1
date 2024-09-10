package com.avaliacao.domains.enums;

public enum UnidadeMedida {

    UN(0, "UN"), KG(1, "KG"), LT(2, "LT"), FR(3, "FR"), PCT(4, "PCT");

    private Integer id;
    private String unidadeMedida;
    
    private UnidadeMedida(Integer id, String unidadeMedida) {
        this.id = id;
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public static UnidadeMedida toEnum(Integer id) {

        if(id == null) {
            return null;
        }

        for (UnidadeMedida x: UnidadeMedida.values()) {
            if(id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Unidade inválidas");
    }
}
