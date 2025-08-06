package pos.tech.gatrohub.domain.entity;

import java.util.List;

public class ResultadoPaginado<T> {
    private List<T> itens;
    private int paginaAtual;
    private int totalPaginas;
    private long totalElementos;

    public ResultadoPaginado(List<T> itens, int paginaAtual, int totalPaginas, long totalElementos) {
        this.itens = itens;
        this.paginaAtual = paginaAtual;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<T> getItens() {
        return itens;
    }

    public void setItens(List<T> itens) {
        this.itens = itens;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }
}
