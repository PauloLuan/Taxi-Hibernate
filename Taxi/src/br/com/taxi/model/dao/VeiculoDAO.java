package br.com.taxi.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.taxi.hibernate.HibernateUtil;
import br.com.taxi.model.Veiculo;

public class VeiculoDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void SalvarVeiculo(Veiculo veiculo) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(veiculo);
		tx.commit();
		session.close();
	}

	public void DeletarVeiculo(Veiculo veic) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(veic);
		tx.commit();
		session.close();
	}

	public void AlterarVeiculo(Veiculo veic) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(veic);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> getVeiculosNaoAlocados() {
		List<Veiculo> veiculosAlocados;
		List<Veiculo> veiculosNaoAlocados;
		Session session = sessionFactory.openSession();

		//TODO: colocar regra de negócio no Select para filtrar apenas os veículos não alocados.
		veiculosNaoAlocados = session.createQuery(
				" FROM Veiculo").list();		

		veiculosAlocados = session.createQuery(
				"SELECT o.veiculo" + 
						" FROM Ocorrencia o" + 
				" WHERE o.devolvido = 'false'").list();

		for (Veiculo veiculoAlocado : veiculosAlocados) {
			veiculosNaoAlocados.remove(veiculoAlocado);
		}

		session.close();
		return veiculosNaoAlocados;
	}
	

	@SuppressWarnings("unchecked")
	public List<Veiculo> getVeiculosAlocados() {
		List<Veiculo> veiculosAlocados;
		Session session = sessionFactory.openSession();

		veiculosAlocados = session.createQuery(
				"SELECT o.veiculo" + 
						" FROM Ocorrencia o" + 
				" WHERE o.devolvido = 'false'").list();

		session.close();
		return veiculosAlocados;
	}
	


}
