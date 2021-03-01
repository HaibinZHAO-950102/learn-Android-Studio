package com.example.bayerischenformel;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bayerischenformel.databinding.FragmentHundredtofiveBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hundredtofive#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hundredtofive extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public hundredtofive() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hundredtofive.
     */
    // TODO: Rename and change types and number of parameters
    public static hundredtofive newInstance(String param1, String param2) {
        hundredtofive fragment = new hundredtofive();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        FragmentHundredtofiveBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hundredtofive, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setNumber(Double.valueOf(binding.editTextNumberDecimal2.getText().toString()));
                myViewModel.htf();
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setNumber(0);
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_hundredtofive_to_fivetohundred);
            }
        });

        return binding.getRoot();

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_hundredtofive, container, false);
    }
}