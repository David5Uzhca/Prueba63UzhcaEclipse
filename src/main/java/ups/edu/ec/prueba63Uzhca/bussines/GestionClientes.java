package ups.edu.ec.prueba63Uzhca.bussines;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.prueba63Uzhca.DAO.ClienteDAO;
import ups.edu.ec.prueba63Uzhca.model.Cliente;

@Stateless
public class GestionClientes {
	
	@Inject
	private ClienteDAO daoCliente;
	
	public void guardarCliente(Cliente cliente) {
		Cliente per = daoCliente.read(cliente.getCodigo());
		if (per != null) {
			daoCliente.update(cliente);
		}else {
			daoCliente.insert(cliente);
		}
	}
	
	public void actualizarCliente(Cliente cliente) throws Exception {
		Cliente per = daoCliente.read(cliente.getCodigo());
		if (per != null) {
			daoCliente.update(cliente);
		}else {
			throw new Exception("La cliente no existe");
		}
	}
	
	public  Cliente getClientePorCedula(String cedula) throws Exception{
		if(cedula.length()!=10)
			throw new Exception("Cedula incorrecta");
		return daoCliente.getClientePorCedula(cedula);
	}
	
	
	public void borrarcliente(int codigo){daoCliente.remove(codigo);}
	
	public List<Cliente> getclientes(){return daoCliente.getAll();}
	
	
	
}
