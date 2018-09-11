package tipiniquim.com.br.consumerwebservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tipiniquim.com.br.consumerwebservice.config.RetrofitConfig;
import tipiniquim.com.br.consumerwebservice.modelo.ClienteTO;
import tipiniquim.com.br.consumerwebservice.modelo.Usuario;

public class SplashScreen extends AppCompatActivity {

    private Button botao;
    private TextView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        botao = findViewById(R.id.button);
        lista = findViewById(R.id.usuarios);
    }

    public void buscar(View v) {

        Call<ClienteTO> call = new RetrofitConfig().getUsuarioService().buscarUsuarios();

        call.enqueue(new Callback<ClienteTO>() {
            @Override
            public void onResponse(Call<ClienteTO> call, Response<ClienteTO> response) {

                if (response.isSuccessful()) {
                    ClienteTO cliente = response.body();

                    if (cliente != null) {

                        for (Usuario user : cliente.getUsuarios()) {
                            lista.setText(user.toString());
                        }

                    }

                }

            }

            @Override
            public void onFailure(Call<ClienteTO> call, Throwable t) {

            }
        });
    }
}
