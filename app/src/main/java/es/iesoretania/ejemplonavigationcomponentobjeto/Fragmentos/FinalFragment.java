package es.iesoretania.ejemplonavigationcomponentobjeto.Fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import es.iesoretania.ejemplonavigationcomponentobjeto.R;
import es.iesoretania.ejemplonavigationcomponentobjeto.databinding.FragmentFinalBinding;

public class FinalFragment extends Fragment {
    private FragmentFinalBinding binding;

    public FinalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFinalBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.botonContinuarFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_finalFragment_to_inicioFragment);
            }
        });
    }
}