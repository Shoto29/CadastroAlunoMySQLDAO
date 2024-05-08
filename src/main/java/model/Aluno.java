package model;

import DAO.AlunoDAO;
import java.util.ArrayList;

public class Aluno extends Pessoa {

    private String curso;
    private int fase;
    AlunoDAO dao;

    public Aluno() {
        this(0, "", 0, "", 0);
    }

    public Aluno(String curso, int fase) {
        this.curso = curso;
        this.fase = fase;
    }

    public Aluno(int id, String nome, int idade, String curso, int fase) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
        dao = new AlunoDAO();
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return super.toString() + ", curso = " + curso + ", fase = " + fase;
    }

    public ArrayList<Aluno> getMinhaLista() {
        return dao.getMinhaLista();

    }

    //Cria um aluno novo
    public boolean insertAlunoBD(String nome, int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        dao.insertAlunoBD(objeto);
        return true;
    }

    //Deleta Aluno pelo ID
    public boolean deleteAlunoBD(int id) {

        dao.deleteAlunoBD(id);
        return true;
    }

    //Atualiza um aluno pelo ID
    public boolean updateAlunoBD(int id, String nome, int idade, String curso, int fase) {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        dao.updateAlunoBD(objeto);
        return true;
    }

    

    //Carrega 
    public Aluno carregaAluno(int id) {
        return dao.carregaAluno(id);
    }

    public int maiorID() {
        return dao.maiorID();
    }
}
