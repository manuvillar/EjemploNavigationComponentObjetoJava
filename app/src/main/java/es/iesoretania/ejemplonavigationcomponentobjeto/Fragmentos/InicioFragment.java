package es.iesoretania.ejemplonavigationcomponentobjeto.Fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import es.iesoretania.ejemplonavigationcomponentobjeto.Datos;
import es.iesoretania.ejemplonavigationcomponentobjeto.databinding.FragmentInicioBinding;

public class InicioFragment extends Fragment {
    private FragmentInicioBinding binding;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInicioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Capturamos el Navigation Component
        final NavController navController = Navigation.findNavController(view);

        //Definimos la acción del botón continuar con un Listener.
        binding.botonContinuarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = "";
                Integer numero = 0;
                if (binding.EditTextTexto.getText().toString().isEmpty() ||
                        binding.EditTextNumero.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Debes introducir algún valor en todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    texto = binding.EditTextTexto.getText().toString();
                    numero = Integer.parseInt(binding.EditTextNumero.getText().toString());
                    //Creo un objeto de tipo Datos.
                    Datos registro = new Datos(texto,numero);

                    //Una vez comprobado que los EditText no están vacíos, y almacenados sus valores, iniciamos una navegación
                    //al fragmento SegundoFragment pasánsole los argumentos.

                    InicioFragmentDirections.ActionInicioFragmentToSegundoFragment accion =
                            InicioFragmentDirections.actionInicioFragmentToSegundoFragment(registro);

                    //Lanzamos esa navegación, que contendrá los argumentos anteriores.
                    navController.navigate(accion);
                }
            }
        });

        //Definimos la acción del botón cancelar con un Listener.
        binding.botonCancelarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.EditTextTexto.setText("");
                binding.EditTextNumero.setText("");
            }
        });
    }
}