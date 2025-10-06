package com.example.autotools.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VeiculoDto {

    @JsonProperty("valor")
    private String preco;

    @JsonProperty("marca")
    private String marca;

    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("cor")
    private String cor;

    @JsonProperty("anoModelo")
    private String ano;

    @JsonProperty("municipio")
    private String cidade;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("placa")
    private String placa;

    @JsonProperty("situacao")
    private String situacao;

    @JsonProperty("codigoFipe")
    private String codigoFipe;

    // Getters and Setters
    public String getPreco() { return preco; }
    public void setPreco(String preco) { this.preco = preco; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getAno() { return ano; }
    public void setAno(String ano) { this.ano = ano; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }
    public String getCodigoFipe() { return codigoFipe; }
    public void setCodigoFipe(String codigoFipe) { this.codigoFipe = codigoFipe; }
}