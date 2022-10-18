package com.example.cadastro15102022.Entityes;

import java.util.Date;

public class Cliente {
    Integer id;
    String nomeCliente, cpfCliente;
    Date dataNascCliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Date getDataNascCliente() {
        return dataNascCliente;
    }

    public void setDataNascCliente(Date dataNascCliente) {
        this.dataNascCliente = dataNascCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", cpfCliente='" + cpfCliente + '\'' +
                ", dataNascCliente=" + dataNascCliente +
                '}';
    }
}
