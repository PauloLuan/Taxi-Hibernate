package br.com.taxi.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.taxi.hibernate.HibernateUtil;
import br.com.taxi.model.Funcionario;

public class FuncionarioDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void SalvarFuncionario(Funcionario funcionario) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(funcionario);
		tx.commit();
		session.close();
	}

	public void DeletarFuncionario(Funcionario func) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(func);
		tx.commit();
		session.close();
	}

	public void AlterarFuncionario(Funcionario func) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(func);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getFuncionario(int registro) {
		List<Funcionario> funcionarios;
		Session session = sessionFactory.openSession();
		funcionarios = session.createQuery(
				"FROM Funcionario where registro = '" + registro + "'").list();
		session.close();
		return funcionarios;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getFuncionariosNaoAlocados() {
		List<Funcionario> funcionariosAlocados;
		List<Funcionario> funcionariosNaoAlocados;
		Session session = sessionFactory.openSession();

		// TODO: colocar regra de negócio no Select para filtrar apenas os
		// funcionários não alocados.

		funcionariosNaoAlocados = session.createQuery(" FROM Funcionario")
				.list();

		funcionariosAlocados = session.createQuery(
				"SELECT o.funcionario" 
				+ " FROM Ocorrencia o"
				+ " WHERE o.devolvido = 'false'").list();

		for (Funcionario funcionarioAlocado : funcionariosAlocados) {
			funcionariosNaoAlocados.remove(funcionarioAlocado);
		}

		session.close();
		return funcionariosNaoAlocados;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getFuncionariosAlocados() {
		List<Funcionario> funcionariosAlocados;
		Session session = sessionFactory.openSession();

		funcionariosAlocados = session.createQuery(
				"SELECT o.funcionario" + " FROM Ocorrencia o"
						+ " WHERE o.devolvido = 'false'").list();

		session.close();
		return funcionariosAlocados;
	}
}
