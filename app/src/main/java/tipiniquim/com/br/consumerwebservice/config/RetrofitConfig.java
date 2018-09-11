package tipiniquim.com.br.consumerwebservice.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tipiniquim.com.br.consumerwebservice.modelo.ClienteTO;
import tipiniquim.com.br.consumerwebservice.modelo.UsuarioInt;

public class RetrofitConfig implements Callback<ClienteTO> {

    private String url;
    private static final String BASE_URL = "http://192.168.1.89:8280/WebService/backend/";
    private Retrofit retrofit;
    public ClienteTO clienteTO;
    //"http://192.168.1.89:8280/WebService/backend/";

    public RetrofitConfig() {
        Gson gson = new GsonBuilder().setLenient().create();

        this.retrofit =  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public UsuarioInt getUsuarioService() {
        return this.retrofit.create(UsuarioInt.class);
    }

    public void start() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        UsuarioInt userInt = retrofit.create(UsuarioInt.class);

        Call<ClienteTO> call = userInt.buscarUsuarios();

        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<ClienteTO> call, Response<ClienteTO> response) {

        if (response.isSuccessful()) {
            clienteTO = response.body();

            if (clienteTO != null) {
                new ClienteTO(clienteTO);
            }

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<ClienteTO> call, Throwable t) {

        t.printStackTrace();
    }
}
