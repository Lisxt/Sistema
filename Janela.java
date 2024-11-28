package view;

import javax.swing.*; //Importa todas as classes da biblioteca Swing para criar interfaces gráficas.
import java.awt.*; //Importa as classes do pacote AWT (Abstract Window Toolkit) - funcionalidades gráficas como layouts e componentes visuais.

public class Janela {

    public static void main(String[] args) {
        // Criação da janela principal (tela inicial)
        JFrame telaInicial = new JFrame("Gestão Acadêmica");
        telaInicial.setSize(500, 400); //tamanho da janela
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Define que a aplicação será fechada ao clicar no X
        telaInicial.setLayout(new BorderLayout()); //layout da janela principal

        // Painel central 
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(5, 1, 10, 10)); 
        painelCentral.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); 
        painelCentral.setBackground(Color.LIGHT_GRAY); 
        
        // Título da tela
        JLabel titulo = new JLabel("Gestão Acadêmica", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24)); 
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); 

        // Botões da tela inicial
        JButton btnAluno = new JButton("Gerenciar Alunos");
        JButton btnProfessor = new JButton("Gerenciar Professores");
        JButton btnCurso = new JButton("Gerenciar Cursos");
        JButton btnRelatorios = new JButton("Relatorios");
        JButton btnSair = new JButton("Sair");

        // Adicionando os botões ao painel central
        painelCentral.add(btnAluno);
        painelCentral.add(btnProfessor);
        painelCentral.add(btnCurso);
        painelCentral.add(btnRelatorios);
        painelCentral.add(btnSair);

        // Adicionando o título e o painel central à janela principal
        telaInicial.add(titulo, BorderLayout.NORTH);
        telaInicial.add(painelCentral, BorderLayout.CENTER);

        // Definindo o comportamento do botão "Sair" (fecha a aplicação)
        btnSair.addActionListener(e -> System.exit(0));

        // Ações para os botões de gerenciar alunos, professores, cursos e relatórios
        btnAluno.addActionListener(e -> abrirMenuAluno());
        btnProfessor.addActionListener(e -> abrirMenuProfessor());
        btnCurso.addActionListener(e -> abrirMenuCurso());
        btnRelatorios.addActionListener(e -> abrirMenuRelatorios());

        //Deixando a janela visível
        telaInicial.setVisible(true);
    }

    //Método para abrir o menu de gerenciamento de Alunos
    private static void abrirMenuAluno() {
        JFrame menuAluno = new JFrame("Menu Aluno");
        menuAluno.setSize(400, 300); 
        menuAluno.setLayout(new GridLayout(4, 1)); 

        // Botões para cadastrar e consultar alunos, e voltar
        JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
        JButton btnConsultarAluno = new JButton("Consultar Aluno");
        JButton btnVoltar = new JButton("Voltar");

        //Adicionando os botões ao menu de alunos
        menuAluno.add(btnCadastrarAluno);
        menuAluno.add(btnConsultarAluno);
        menuAluno.add(btnVoltar);

        //Ações para os botões
        btnCadastrarAluno.addActionListener(e -> exibirJanelaCadastro("Aluno"));
        btnConsultarAluno.addActionListener(e -> exibirJanelaConsulta("Aluno"));
        btnVoltar.addActionListener(e -> menuAluno.dispose()); 

        menuAluno.setVisible(true); 
    }

    // Método para abrir o menu de gerenciamento de Professores
    private static void abrirMenuProfessor() {
        JFrame menuProfessor = new JFrame("Menu Professor");
        menuProfessor.setSize(400, 300); 
        menuProfessor.setLayout(new GridLayout(4, 1)); 

        // Botões para cadastrar e consultar professores, e voltar
        JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
        JButton btnConsultarProfessor = new JButton("Consultar Professor");
        JButton btnVoltar = new JButton("Voltar");

        // Adicionando os botões ao menu de professores
        menuProfessor.add(btnCadastrarProfessor);
        menuProfessor.add(btnConsultarProfessor);
        menuProfessor.add(btnVoltar);

        // Ações para os botões
        btnCadastrarProfessor.addActionListener(e -> exibirJanelaCadastro("Professor"));
        btnConsultarProfessor.addActionListener(e -> exibirJanelaConsulta("Professor"));
        btnVoltar.addActionListener(e -> menuProfessor.dispose()); 

        menuProfessor.setVisible(true);
    }

    // Método para abrir o menu de gerenciamento de Cursos
    private static void abrirMenuCurso() {
        JFrame menuCurso = new JFrame("Menu Curso");
        menuCurso.setSize(400, 300); 
        menuCurso.setLayout(new GridLayout(5, 1)); 

        // Botões para cadastrar curso, consultar curso, vincular alunos/professores e voltar
        JButton btnCadastrarCurso = new JButton("Cadastrar Curso");
        JButton btnConsultarCurso = new JButton("Consultar Curso");
        JButton btnVincular = new JButton("Vincular Alunos/Professores");
        JButton btnVoltar = new JButton("Voltar");

        // Adicionando os botões ao menu de cursos
        menuCurso.add(btnCadastrarCurso);
        menuCurso.add(btnConsultarCurso);
        menuCurso.add(btnVincular);
        menuCurso.add(btnVoltar);

        // Ações para os botões
        btnCadastrarCurso.addActionListener(e -> exibirJanelaCadastro("Curso"));
        btnConsultarCurso.addActionListener(e -> exibirJanelaConsulta("Curso"));
        btnVincular.addActionListener(e -> exibirJanelaVinculacao()); 

        btnVoltar.addActionListener(e -> menuCurso.dispose()); 

        menuCurso.setVisible(true); 
    }

    // Método para exibir a janela de cadastro (Aluno, Professor ou Curso)
    private static void exibirJanelaCadastro(String tipo) {
        JFrame cadastro = new JFrame("Cadastrar " + tipo);
        cadastro.setSize(400, 300); 
        cadastro.setLayout(new GridLayout(4, 2)); 

        // Labels e campos de texto para o cadastro
        JLabel lblCampo1 = new JLabel(tipo.equals("Aluno") ? "Nome:" : "Nome:");
        JTextField txtCampo1 = new JTextField();

        JLabel lblCampo2 = new JLabel(tipo.equals("Aluno") ? "Idade:" : 
                                      tipo.equals("Professor") ? "Especialidade:" : "Carga Horária:");
        JTextField txtCampo2 = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        // Adicionando componentes à janela de cadastro
        cadastro.add(lblCampo1);
        cadastro.add(txtCampo1);
        cadastro.add(lblCampo2);
        cadastro.add(txtCampo2);
        cadastro.add(btnSalvar);
        cadastro.add(btnCancelar);

        // Ação do botão "Salvar"
        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(cadastro, tipo + " cadastrado com sucesso!"); 
            cadastro.dispose(); // Fecha a janela de cadastro
        });

        // Ação do botão "Cancelar"
        btnCancelar.addActionListener(e -> cadastro.dispose()); // Fecha a janela de cadastro sem salvar

        cadastro.setVisible(true); // Torna a janela de cadastro visível
    }

    // Método para exibir a janela de consulta (Aluno, Professor ou Curso)
    private static void exibirJanelaConsulta(String tipo) {
        JFrame consulta = new JFrame("Consultar " + tipo);
        consulta.setSize(400, 300); 
        consulta.setLayout(new GridLayout(3, 1)); 
        
        // Campos para pesquisa
        JTextField txtPesquisa = new JTextField();
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditarExcluir = new JButton("Editar/Excluir");

        // Adicionando componentes à janela de consulta
        consulta.add(new JLabel("Digite o nome ou matrícula:"));
        consulta.add(txtPesquisa);
        consulta.add(btnPesquisar);
        consulta.add(btnEditarExcluir);

        // Ações dos botões
        btnPesquisar.addActionListener(e -> JOptionPane.showMessageDialog(consulta, tipo + " encontrado!"));
        btnEditarExcluir.addActionListener(e -> exibirJanelaEdicao(tipo)); 
        consulta.setVisible(true); 
    }

    // Método para exibir a janela de edição/exclusão (Aluno, Professor ou Curso)
    private static void exibirJanelaEdicao(String tipo) {
        JFrame edicao = new JFrame("Editar/Excluir " + tipo);
        edicao.setSize(400, 300); 
        edicao.setLayout(new GridLayout(4, 2)); 

        // Campos para edição
        JLabel lblCampo1 = new JLabel("Novo Nome:");
        JTextField txtCampo1 = new JTextField();

        JLabel lblCampo2 = new JLabel(tipo.equals("Aluno") ? "Nova Idade:" : 
                                      tipo.equals("Professor") ? "Nova Especialidade:" : "Nova Carga Horária:");
        JTextField txtCampo2 = new JTextField();

        JButton btnSalvar = new JButton("Salvar Alterações");
        JButton btnExcluir = new JButton("Excluir");

        // Adicionando componentes à janela de edição
        edicao.add(lblCampo1);
        edicao.add(txtCampo1);
        edicao.add(lblCampo2);
        edicao.add(txtCampo2);
        edicao.add(btnSalvar);
        edicao.add(btnExcluir);

        // Ações dos botões
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

    // Método para exibir a janela de vinculação de alunos e professores aos cursos
    private static void exibirJanelaVinculacao() {
        JFrame vinculacao = new JFrame("Vincular Alunos/Professores");
        vinculacao.setSize(400, 300); 
        vinculacao.setLayout(new GridLayout(3, 1)); 

        // Botões para matricular aluno e associar professor
        JButton btnMatricularAluno = new JButton("Matricular Alunos");
        JButton btnAssociarProfessor = new JButton("Associar Professores");
        JButton btnVoltar = new JButton("Voltar");

        // Adicionando botões à janela de vinculação
        vinculacao.add(btnMatricularAluno);
        vinculacao.add(btnAssociarProfessor);
        vinculacao.add(btnVoltar);

        // Ações dos botões
        btnMatricularAluno.addActionListener(e -> JOptionPane.showMessageDialog(vinculacao, "Aluno matriculado com sucesso!"));
        btnAssociarProfessor.addActionListener(e -> JOptionPane.showMessageDialog(vinculacao, "Professor associado com sucesso!"));

        btnVoltar.addActionListener(e -> vinculacao.dispose()); 
        vinculacao.setVisible(true); 
    }

    // Método para abrir o menu de relatórios
    private static void abrirMenuRelatorios() {
        JFrame menuRelatorios = new JFrame("Relatórios");
        menuRelatorios.setSize(400, 300); 
        menuRelatorios.setLayout(new GridLayout(3, 1)); 

        // Botões para relatórios de estudantes, professores e voltar
        JButton btnRelatorioEstudantes = new JButton("Relatório de Estudantes");
        JButton btnRelatorioProfessores = new JButton("Relatório de Professores");
        JButton btnVoltar = new JButton("Voltar");

        // Adicionando os botões ao menu de relatórios
        menuRelatorios.add(btnRelatorioEstudantes);
        menuRelatorios.add(btnRelatorioProfessores);
        menuRelatorios.add(btnVoltar);

        // Ações dos botões
        btnRelatorioEstudantes.addActionListener(e -> exibirRelatorio("Estudantes"));
        btnRelatorioProfessores.addActionListener(e -> exibirRelatorio("Professores"));

        btnVoltar.addActionListener(e -> menuRelatorios.dispose()); 

        menuRelatorios.setVisible(true); 
    }

    // Método para exibir o relatório de estudantes ou professores
    private static void exibirRelatorio(String tipo) {
        JFrame relatorio = new JFrame("Relatório de " + tipo);
        relatorio.setSize(400, 300); 
        relatorio.setLayout(new BorderLayout()); 

        JTextArea areaRelatorio = new JTextArea();
        areaRelatorio.setEditable(false); // A área do relatório não é editável
        JScrollPane scrollPane = new JScrollPane(areaRelatorio); // Permite rolar o conteúdo

        JButton btnFechar = new JButton("Fechar");

        // Exemplo de dados fictícios no relatório
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

        // Adicionando componentes à janela de relatório
        relatorio.add(scrollPane, BorderLayout.CENTER);
        relatorio.add(btnFechar, BorderLayout.SOUTH);

        // Evento do botão "Fechar"
        btnFechar.addActionListener(e -> relatorio.dispose()); // Fecha a janela de relatório

        relatorio.setVisible(true); // Torna a janela de relatório visível
    }
}
