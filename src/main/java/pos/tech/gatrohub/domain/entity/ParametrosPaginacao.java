package pos.tech.gatrohub.domain.entity;

public class ParametrosPaginacao {
    private int pagina;
    private int tamanho;

    public ParametrosPaginacao(int pagina, int tamanho) {
        this.pagina = pagina;
        this.tamanho = tamanho;
    }

    public int getPagina() {
        return pagina;
    }

    public int getTamanho() {
        return tamanho;
    }

}
