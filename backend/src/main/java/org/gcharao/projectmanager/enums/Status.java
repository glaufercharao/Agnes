package org.gcharao.projectmanager.enums;

public enum Status {

    IN_PROGRESS(0, "IN_PROGRESS"), PENDING(1, "PENDING"),
    CLOSE(2, "PENDING"), DONE(3, "CLOSE");

    private Integer codigo;
    private String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static Status toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for (Status value : Status.values()) {
            if(codigo.equals(value.getCodigo()))
                return value;
        }
        throw new IllegalArgumentException("Status inválido!");
    }

    public String getDescricao() {
        return descricao;
    }
}
