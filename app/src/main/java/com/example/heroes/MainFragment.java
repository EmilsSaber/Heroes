package com.example.heroes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

    private EditText editText;
    private Button button;
    public final static String KEY = "key";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.hello);
        editText = view.findViewById(R.id.edit);

        Bundle bundle = new Bundle();
        bundle.putString( KEY, editText.getText().toString());

        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).addToBackStack("").commit();

            }
        });

    }
}