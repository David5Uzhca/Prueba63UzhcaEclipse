package ups.edu.ec.prueba63Uzhca.bussines;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.prueba63Uzhca.DAO.ClienteDAO;
import ups.edu.ec.prueba63Uzhca.model.Cliente;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0302447347");
		cliente.setNombre("David Uzhca");
		cliente.setMes("Abril");
		cliente.setDeuda(152.12);
		
		daoCliente.insert(cliente);
	}

}
