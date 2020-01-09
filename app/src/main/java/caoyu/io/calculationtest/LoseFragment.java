package caoyu.io.calculationtest;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import caoyu.io.calculationtest.databinding.FragmentLoseBinding;
import caoyu.io.calculationtest.databinding.FragmentWinBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoseFragment extends Fragment {


    public LoseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel viewModel;
        viewModel = ViewModelProviders.of(requireActivity(), new SavedStateViewModelFactory(requireActivity().getApplication(), requireActivity())).get(MyViewModel.class);
        FragmentLoseBinding fragmentLoseBinding;
        fragmentLoseBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lose, container, false);

        fragmentLoseBinding.setData(viewModel);
        fragmentLoseBinding.setLifecycleOwner(requireActivity());
        fragmentLoseBinding.button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_loseFragment_to_titleFragment);
            }
        });
        return fragmentLoseBinding.getRoot();
    }

}
