package br.com.planosemeador.planosemeador;

public class Fornecedor {
    String nomeFornecedor;
    String enderecoFornecedor;
    String telefoneFornecedor;
    String desconto;

    public Fornecedor() {
    }

    public Fornecedor(String nomeFornecedor, String telefoneFornecedor, String enderecoFornecedor, String desconto) {
        this.nomeFornecedor = nomeFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
        this.enderecoFornecedor = enderecoFornecedor;
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

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }
}

