public class ProdutosDTO {
    private Integer id;
    private String nome;
    private Integer valor;
    private String status;

    // Construtor vazio (PRECISA ter)
    public ProdutosDTO() {
    }

    // Construtor completo (opcional, se quiser usar)
    public ProdutosDTO(Integer id, String nome, Integer valor, String status) {
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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
