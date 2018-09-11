package tipiniquim.com.br.consumerwebservice.modelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface UsuarioInt {

    @POST("get")
    Call<ClienteTO> buscarUsuarios();
}
