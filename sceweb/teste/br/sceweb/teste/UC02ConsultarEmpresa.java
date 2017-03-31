package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	public static Empresa empresa;
	public static EmpresaDAO empresaDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa= new Empresa();
		empresaDao = new EmpresaDAO();
			empresa.setNomeDaEmpresa("Casas Bahia S/A");
			empresa.setCnpj("60430951000122");
			empresa.setNomeFantasia("Casas Bahia");
			empresa.setEndereco("rua taquari");
			empresa.setTelefone("111111");
	}
	
	@Before
	public void preCondicao_insereEmpresa(){
		empresaDao.adiciona(empresa);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDao.exclui(empresa.getCnpj());
	}

	@Test
	public void CT01UC02ConsultaEmpresa_cnpj_valido() {

		assertTrue(empresa.equals(empresaDao.consultaEmpresa("60430951000122")));

		}

}
