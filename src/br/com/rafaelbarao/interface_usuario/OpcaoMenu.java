package br.com.rafaelbarao.interface_usuario;

public class OpcaoMenu {
    private Integer opcao;
    private String descricao;

    public OpcaoMenu() {
        this.opcao = -1;
        this.descricao = "";
    }

    public OpcaoMenu(Integer opcao, String descricao) {
        this.opcao = opcao == null ? Integer.valueOf(-1) : opcao;
        this.descricao = descricao == null ? "" : descricao;
    }

    //"Opção %s Descrição %s "
    public String getLayoutImpressao(String layout) {
        return String.format(layout, opcao.toString(), descricao.toUpperCase());
    }

    public String getLayoutImpressao() {
        return opcao.toString() + " - " + descricao.toUpperCase();
    }

    public Integer getOpcao() {
        return opcao;
    }

    public String getDescricao() {
        return descricao;
    }
}
