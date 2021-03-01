package com.example.test;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.test.databinding.FragmentDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detail extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public detail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment detail.
     */
    // TODO: Rename and change types and number of parameters
    public static detail newInstance(String param1, String param2) {
        detail fragment = new detail();
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

        FragmentDetailBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(getActivity());

        myViewModel.question();

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String percent = binding.editTextNumber.getText().toString();
                if (TextUtils.isEmpty(percent)) {
                    percent = "0";
                }
                myViewModel.setNumber(Integer.valueOf(percent));
                boolean right = myViewModel.check();

                if (right) {
                    myViewModel.question();
                    binding.editTextNumber.setText("");
                    Toast.makeText(getActivity(), "Right!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_detail, container, false);
        return binding.getRoot();
    }
}