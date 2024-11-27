package view;
import javax.swing.*;
import java.awt.*;
public class Janela {

    public static void main(String[] args) {
    	// Tela Inicial
        JFrame telaInicial = new JFrame("Gestão Acadêmica");
        telaInicial.setSize(500, 400);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setLayout(new BorderLayout());

        // Painel principal com borda e layout moderno
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(5, 1, 10, 10)); // GridLayout com 5 linhas e 1 coluna
        painelCentral.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Margem
        painelCentral.setBackground(Color.LIGHT_GRAY);

        // Título estilizado
        JLabel titulo = new JLabel("Gestão Acadêmica", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        // Botões com estilo
        JButton btnAluno = new JButton("Gerenciar Alunos");
        JButton btnProfessor = new JButton("Gerenciar Professores");
        JButton btnCurso = new JButton("Gerenciar Cursos");
        JButton btnRelatorios = new JButton("Relatorios");
        JButton btnSair = new JButton("Sair");

        // Adicionar os botões ao painel central
        painelCentral.add(btnAluno);
        painelCentral.add(btnProfessor);
        painelCentral.add(btnCurso);
        painelCentral.add(btnRelatorios);
        painelCentral.add(btnSair);

        // Adicionar título e painel ao JFrame
        telaInicial.add(titulo, BorderLayout.NORTH);
        telaInicial.add(painelCentral, BorderLayout.CENTER);

        // Botão Sair
        btnSair.addActionListener(e -> System.exit(0));

        // Botões que abrem menus
        btnAluno.addActionListener(e -> abrirMenuAluno());
        btnProfessor.addActionListener(e -> abrirMenuProfessor());
        btnCurso.addActionListener(e -> abrirMenuCurso());
        btnRelatorios.addActionListener(e -> abrirMenuRelatorios());

        // Tornar visível
        telaInicial.setVisible(true);
    }


    // Menu Aluno
    private static void abrirMenuAluno() {
        JFrame menuAluno = new JFrame("Menu Aluno");
        menuAluno.setSize(400, 300);
        menuAluno.setLayout(new GridLayout(4, 1));

        JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
        JButton btnConsultarAluno = new JButton("Consultar Aluno");
        JButton btnVoltar = new JButton("Voltar");

        menuAluno.add(btnCadastrarAluno);
        menuAluno.add(btnConsultarAluno);
        menuAluno.add(btnVoltar);

        // Eventos
        btnCadastrarAluno.addActionListener(e -> exibirJanelaCadastro("Aluno"));
        btnConsultarAluno.addActionListener(e -> exibirJanelaConsulta("Aluno"));

        btnVoltar.addActionListener(e -> menuAluno.dispose());

        menuAluno.setVisible(true);
    }

    // Menu Professor
    private static void abrirMenuProfessor() {
        JFrame menuProfessor = new JFrame("Menu Professor");
        menuProfessor.setSize(400, 300);
        menuProfessor.setLayout(new GridLayout(4, 1));

        JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
        JButton btnConsultarProfessor = new JButton("Consultar Professor");
        JButton btnVoltar = new JButton("Voltar");

        menuProfessor.add(btnCadastrarProfessor);
        menuProfessor.add(btnConsultarProfessor);
        menuProfessor.add(btnVoltar);

        // Eventos
        btnCadastrarProfessor.addActionListener(e -> exibirJanelaCadastro("Professor"));
        btnConsultarProfessor.addActionListener(e -> exibirJanelaConsulta("Professor"));

        btnVoltar.addActionListener(e -> menuProfessor.dispose());

        menuProfessor.setVisible(true);
    }

    // Menu Curso
    private static void abrirMenuCurso() {
        JFrame menuCurso = new JFrame("Menu Curso");
        menuCurso.setSize(400, 300);
        menuCurso.setLayout(new GridLayout(5, 1));

        JButton btnCadastrarCurso = new JButton("Cadastrar Curso");
        JButton btnConsultarCurso = new JButton("Consultar Curso");
        JButton btnVincular = new JButton("Vincular Alunos/Professores");
        JButton btnVoltar = new JButton("Voltar");

        menuCurso.add(btnCadastrarCurso);
        menuCurso.add(btnConsultarCurso);
        menuCurso.add(btnVincular);
        menuCurso.add(btnVoltar);

        // Eventos
        btnCadastrarCurso.addActionListener(e -> exibirJanelaCadastro("Curso"));
        btnConsultarCurso.addActionListener(e -> exibirJanelaConsulta("Curso"));
        btnVincular.addActionListener(e -> exibirJanelaVinculacao());

        btnVoltar.addActionListener(e -> menuCurso.dispose());

        menuCurso.setVisible(true);
    }

    // Janela para cadastro
    private static void exibirJanelaCadastro(String tipo) {
        JFrame cadastro = new JFrame("Cadastrar " + tipo);
        cadastro.setSize(400, 300);
        cadastro.setLayout(new GridLayout(4, 2));

        JLabel lblCampo1 = new JLabel(tipo.equals("Aluno") ? "Nome:" : "Nome:");
        JTextField txtCampo1 = new JTextField();

        JLabel lblCampo2 = new JLabel(tipo.equals("Aluno") ? "Idade:" : 
                                      tipo.equals("Professor") ? "Especialidade:" : "Carga Horária:");
        JTextField txtCampo2 = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        cadastro.add(lblCampo1);
        cadastro.add(txtCampo1);
        cadastro.add(lblCampo2);
        cadastro.add(txtCampo2);
        cadastro.add(btnSalvar);
        cadastro.add(btnCancelar);

        // Eventos
        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(cadastro, tipo + " cadastrado com sucesso!");
            cadastro.dispose();
        });

        btnCancelar.addActionListener(e -> cadastro.dispose());

        cadastro.setVisible(true);
    }

    // Janela para consulta
    private static void exibirJanelaConsulta(String tipo) {
        JFrame consulta = new JFrame("Consultar " + tipo);
        consulta.setSize(400, 300);
        consulta.setLayout(new GridLayout(3, 1));

        JTextField txtPesquisa = new JTextField();
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditarExcluir = new JButton("Editar/Excluir");

        consulta.add(new JLabel("Digite o nome ou matrícula:"));
        consulta.add(txtPesquisa);
        consulta.add(btnPesquisar);
        consulta.add(btnEditarExcluir);

        // Eventos
        btnPesquisar.addActionListener(e -> JOptionPane.showMessageDialog(consulta, tipo + " encontrado!"));
        btnEditarExcluir.addActionListener(e -> exibirJanelaEdicao(tipo));

        consulta.setVisible(true);
    }

    // Janela para edição/exclusão
    private static void exibirJanelaEdicao(String tipo) {
        JFrame edicao = new JFrame("Editar/Excluir " + tipo);
        edicao.setSize(400, 300);
        edicao.setLayout(new GridLayout(4, 2));

        JLabel lblCampo1 = new JLabel("Novo Nome:");
        JTextField txtCampo1 = new JTextField();

        JLabel lblCampo2 = new JLabel(tipo.equals("Aluno") ? "Nova Idade:" : 
                                      tipo.equals("Professor") ? "Nova Especialidade:" : "Nova Carga Horária:");
        JTextField txtCampo2 = new JTextField();

        JButton btnSalvar = new JButton("Salvar Alterações");
        JButton btnExcluir = new JButton("Excluir");

        edicao.add(lblCampo1);
        edicao.add(txtCampo1);
        edicao.add(lblCampo2);
        edicao.add(txtCampo2);
        edicao.add(btnSalvar);
        edicao.add(btnExcluir);

        // Eventos
        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(edicao, tipo + " editado com sucesso!");
            edicao.dispose();
        });

        btnExcluir.addActionListener(e -> {
            JOptionPane.showMessageDialog(edicao, tipo + " excluído com sucesso!");
            edicao.dispose();
        });

        edicao.setVisible(true);
    }

    // Janela para vinculação
    private static void exibirJanelaVinculacao() {
        JFrame vinculacao = new JFrame("Vincular Alunos/Professores");
        vinculacao.setSize(400, 300);
        vinculacao.setLayout(new GridLayout(3, 1));

        JButton btnMatricularAluno = new JButton("Matricular Alunos");
        JButton btnAssociarProfessor = new JButton("Associar Professores");
        JButton btnVoltar = new JButton("Voltar");

        vinculacao.add(btnMatricularAluno);
        vinculacao.add(btnAssociarProfessor);
        vinculacao.add(btnVoltar);

        // Eventos
        btnMatricularAluno.addActionListener(e -> JOptionPane.showMessageDialog(vinculacao, "Aluno matriculado com sucesso!"));
        btnAssociarProfessor.addActionListener(e -> JOptionPane.showMessageDialog(vinculacao, "Professor associado com sucesso!"));

        btnVoltar.addActionListener(e -> vinculacao.dispose());

        vinculacao.setVisible(true);
    }
    
 // Janela para relatórios
    private static void abrirMenuRelatorios() {
        JFrame menuRelatorios = new JFrame("Relatórios");
        menuRelatorios.setSize(400, 300);
        menuRelatorios.setLayout(new GridLayout(3, 1));

        JButton btnRelatorioEstudantes = new JButton("Relatório de Estudantes");
        JButton btnRelatorioProfessores = new JButton("Relatório de Professores");
        JButton btnVoltar = new JButton("Voltar");

        menuRelatorios.add(btnRelatorioEstudantes);
        menuRelatorios.add(btnRelatorioProfessores);
        menuRelatorios.add(btnVoltar);

        // Eventos
        btnRelatorioEstudantes.addActionListener(e -> exibirRelatorio("Estudantes"));
        btnRelatorioProfessores.addActionListener(e -> exibirRelatorio("Professores"));

        btnVoltar.addActionListener(e -> menuRelatorios.dispose());

        menuRelatorios.setVisible(true);
    }

    // Janela para exibir relatórios
    private static void exibirRelatorio(String tipo) {
        JFrame relatorio = new JFrame("Relatório de " + tipo);
        relatorio.setSize(400, 300);
        relatorio.setLayout(new BorderLayout());

        JTextArea areaRelatorio = new JTextArea();
        areaRelatorio.setEditable(false); // Relatório apenas para leitura
        JScrollPane scrollPane = new JScrollPane(areaRelatorio);

        JButton btnFechar = new JButton("Fechar");

        // Exemplo de dados fictícios
        if (tipo.equals("Estudantes")) {
            areaRelatorio.setText(
                "Estudantes Cadastrados:\n" +
                "1. João Silva - Matriculado em: Programação Java\n" +
                "2. Maria Oliveira - Matriculada em: Estruturas de Dados\n"
            );
        } else if (tipo.equals("Professores")) {
            areaRelatorio.setText(
                "Professores Cadastrados:\n" +
                "1. Prof. Carlos Almeida - Associado ao curso: Banco de Dados\n" +
                "2. Prof. Ana Costa - Associada ao curso: Redes de Computadores\n"
            );
        }

        relatorio.add(scrollPane, BorderLayout.CENTER);
        relatorio.add(btnFechar, BorderLayout.SOUTH);

        // Evento
        btnFechar.addActionListener(e -> relatorio.dispose());

        relatorio.setVisible(true);
    }

}
