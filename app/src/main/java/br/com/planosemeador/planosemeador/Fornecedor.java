package br.com.planosemeador.planosemeador;

public class Fornecedor {
    String nomeFornecedor;
    String enderecoFornecedor;
    String telefoneFornecedor;
    String subcategoria;
    String desconto;

    public Fornecedor() {
    }

    public Fornecedor(String nomeFornecedor, String telefoneFornecedor, String enderecoFornecedor, String subcategoria, String desconto) {
        this.nomeFornecedor = nomeFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
        this.enderecoFornecedor = enderecoFornecedor;
        this.subcategoria = subcategoria;
        this.desconto = desconto;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public String getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    public void setEnderecoFornecedor(String enderecoFornecedor) {
        this.enderecoFornecedor = enderecoFornecedor;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }


}

