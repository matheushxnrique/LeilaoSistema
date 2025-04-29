public class ProdutosDTO {
    private Integer id;
    private String nome;
private Double valor;
    private String status;

    // Construtor vazio (PRECISA ter)
    public ProdutosDTO() {
    }

    // Construtor completo (opcional, se quiser usar)
    public ProdutosDTO(Integer id, String nome, Double valor, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
