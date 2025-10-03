
package com.example.autotools.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CnpjDataDto {

    @JsonProperty("razao_social")
    private String nome;

    @JsonProperty("nome_fantasia")
    private String fantasia;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("municipio")
    private String municipio;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("descricao_situacao_cadastral")
    private String status;

    @JsonProperty("cnae_fiscal_descricao")
    private String atividadePrincipal;

    // Getters and Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getFantasia() { return fantasia; }
    public void setFantasia(String fantasia) { this.fantasia = fantasia; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }

    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAtividadePrincipal() { return atividadePrincipal; }
    public void setAtividadePrincipal(String atividadePrincipal) { this.atividadePrincipal = atividadePrincipal; }
}