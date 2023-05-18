package com.example.ubikatetracking.model;

import java.util.ArrayList;
import java.util.List;

public class Results<T> {
    private List<T> resultados;
    private int totalRegistros;

    public List<T> getResultados() {
        return resultados;
    }

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setResultados(List<T> resultados) {
        this.resultados = resultados;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
}
