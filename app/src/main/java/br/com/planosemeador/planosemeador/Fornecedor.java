package br.com.planosemeador.planosemeador;

public class Fornecedor {
    String nomeFornecedor;
    String enderecoFornecedor;
    String telefoneFornecedor;
    public Fornecedor() {
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeForncedor) {
        this.nomeFornecedor = nomeForncedor;
    }

    public String getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    public void setEnderecoFornecedor(String enderecoFornecedor) {
        this.enderecoFornecedor = enderecoFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }
}

