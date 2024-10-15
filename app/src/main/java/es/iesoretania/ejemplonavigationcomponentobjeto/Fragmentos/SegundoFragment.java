package es.iesoretania.ejemplonavigationcomponentobjeto.Fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import es.iesoretania.ejemplonavigationcomponentobjeto.Datos;
import es.iesoretania.ejemplonavigationcomponentobjeto.R;
import es.iesoretania.ejemplonavigationcomponentobjeto.databinding.FragmentSegundoBinding;

public class SegundoFragment extends Fragment {
    private FragmentSegundoBinding binding;

    public SegundoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSegundoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        //Obtenemos los argumentos si no son nulos.
        if (getArguments()!= null){
            //Los guardamos vía Bundle.
            SegundoFragmentArgs args = SegundoFragmentArgs.fromBundle(getArguments());
            //Los sacamos de este Bundle.
            Datos registro = args.getDatos();

            binding.TextViewTexto.setText("El texto es: "+ registro.getTexto());
            binding.TextViewNumero.setText("El número es: "+ registro.getNumero());
        }

        binding.botonContinuarSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_segundoFragment_to_finalFragment);
            }
        });

        binding.botonCancelarSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_segundoFragment_to_inicioFragment);
            }
        });
    }
}