package tipiniquim.com.br.consumerwebservice.modelo;

import java.io.Serializable;
import java.util.List;

public class ClienteTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Usuario> usuarios;

    public ClienteTO(ClienteTO clienteTO) {
        this.usuarios = clienteTO.usuarios;
    }

    @Override
    public String toString() {
        return "ClienteTO{" +
                "usuarios=" + usuarios +
                '}';
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
