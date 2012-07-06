package br.com.taxi.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.taxi.hibernate.HibernateUtil;
import br.com.taxi.model.Ocorrencia;

public class OcorrenciaDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void SalvarOcorrencia(Ocorrencia ocorrencia) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ocorrencia);
		tx.commit();
		session.close();
	}

	public void DeletarOcorrencia(Ocorrencia ocorrencia) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(ocorrencia);
		tx.commit();
		session.close();
	}

	public void AlterarOcorrencia(Ocorrencia ocorrencia) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ocorrencia);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Ocorrencia> getOcorrencias() {
		List<Ocorrencia> ocorrencias;
		Session session = sessionFactory.openSession();
		ocorrencias = (List<Ocorrencia>) session.createQuery(
				"FROM Ocorrencia o " +
				"WHERE o.devolvido = 'false'")
				.list();
		session.close();
		return ocorrencias;
	}

	@SuppressWarnings("unchecked")
	public Ocorrencia getOcorrencia(int idPedido) {
		List ocorrencias = null;
		Ocorrencia ocorrencia = null;
		Session session = sessionFactory.openSession();

		ocorrencias = session.createQuery(
				"FROM Ocorrencia WHERE id = '" + idPedido + "'").list();

		ocorrencia = (Ocorrencia) ocorrencias.get(0);
		session.close();
		return ocorrencia;
	}

}
