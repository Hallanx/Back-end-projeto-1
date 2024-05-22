import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;

    public Cliente(String nome, String cpf, String tel, String end, String num, String cidade, String estado) {
        this.nome = nome;
        this.cpf = Long.valueOf(cpf.trim());
        this.tel = Long.valueOf(tel.trim());
        this.end = end;
        this.numero = Integer.valueOf(num.trim());
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", tel=" + tel +
                ", end='" + end + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public static class ClienteCRUD {
        private List<Cliente> clientes = new ArrayList<>();

        public void addCliente(Cliente cliente) {
            clientes.add(cliente);
            System.out.println("Cliente adicionado com sucesso!");
        }

        public void listClientes() {
            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado.");
            } else {
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
            }
        }

        public void updateCliente(Long cpf, Cliente newCliente) {
            for (Cliente cliente : clientes) {
                if (cliente.getCpf().equals(cpf)) {
                    cliente.setNome(newCliente.getNome());
                    cliente.setTel(newCliente.getTel());
                    cliente.setEnd(newCliente.getEnd());
                    cliente.setNumero(newCliente.getNumero());
                    cliente.setCidade(newCliente.getCidade());
                    cliente.setEstado(newCliente.getEstado());
                    System.out.println("Cliente atualizado com sucesso!");
                    return;
                }
            }
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }

        public void deleteCliente(Long cpf) {
            Cliente clienteToRemove = null;
            for (Cliente cliente : clientes) {
                if (cliente.getCpf().equals(cpf)) {
                    clienteToRemove = cliente;
                    break;
                }
            }
            if (clienteToRemove != null) {
                clientes.remove(clienteToRemove);
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Cliente com CPF " + cpf + " não encontrado.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteCRUD crud = new ClienteCRUD();
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String tel = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String end = scanner.nextLine();
                    System.out.print("Número: ");
                    String num = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, tel, end, num, cidade, estado);
                    crud.addCliente(cliente);
                    break;
                case 2:
                    crud.listClientes();
                    break;
                case 3:
                    System.out.print("CPF do cliente a ser atualizado: ");
                    Long cpfUpdate = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Novo Nome: ");
                    String newNome = scanner.nextLine();
                    System.out.print("Novo Telefone: ");
                    String newTel = scanner.nextLine();
                    System.out.print("Novo Endereço: ");
                    String newEnd = scanner.nextLine();
                    System.out.print("Novo Número: ");
                    String newNum = scanner.nextLine();
                    System.out.print("Nova Cidade: ");
                    String newCidade = scanner.nextLine();
                    System.out.print("Novo Estado: ");
                    String newEstado = scanner.nextLine();

                    Cliente newCliente = new Cliente(newNome, cpfUpdate.toString(), newTel, newEnd, newNum, newCidade, newEstado);
                    crud.updateCliente(cpfUpdate, newCliente);
                    break;
                case 4:
                    System.out.print("CPF do cliente a ser removido: ");
                    Long cpfDelete = scanner.nextLong();
                    crud.deleteCliente(cpfDelete);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 0);

        scanner.close();
    }
}
