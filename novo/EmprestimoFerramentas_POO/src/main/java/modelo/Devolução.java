package modelo;

public class Devolução {

    //Atributos de Devolução
    private String nomeAmigo;
    private int idFerramenta;
    private String data;
    private int id;
    private String NomeDaFerramentaD;

    //Construtores
    public Devolução() {
        this.nomeAmigo = "";
        this.idFerramenta = 0;
        this.data = "";
        this.id = 0;
        this.NomeDaFerramentaD = "";
    }

    public Devolução(String nomeAmigo, int idFerramenta, String data, int id, String NomeDaFerrmentaD) {
        this.nomeAmigo = nomeAmigo;
        this.idFerramenta = idFerramenta;
        this.data = data;
        this.id = id;
        this.NomeDaFerramentaD = NomeDaFerrmentaD;
    }

    //Getters e Setters
    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeAmigo(String nomeAmigo) {
        this.nomeAmigo = nomeAmigo;
    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomeDaFerramentaD() {
        return NomeDaFerramentaD;
    }

    public void setNomeDaFerramentaD(String NomeDaFerramenta) {
        this.NomeDaFerramentaD = NomeDaFerramenta;
    }

}
