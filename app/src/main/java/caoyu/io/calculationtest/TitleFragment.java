package caoyu.io.calculationtest;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import caoyu.io.calculationtest.databinding.FragmentTitleBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {


    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel viewModel;
        viewModel = ViewModelProviders.of(requireActivity(), new SavedStateViewModelFactory(requireActivity().getApplication(), requireActivity())).get(MyViewModel.class);
        FragmentTitleBinding fragmentTitleBinding;
        fragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false);

        fragmentTitleBinding.setData(viewModel);
        fragmentTitleBinding.setLifecycleOwner(requireActivity());
        fragmentTitleBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_titleFragment_to_questionFragment);
                viewModel.getCurrentScore().setValue(0);
                viewModel.generator();
            }
        });
        return fragmentTitleBinding.getRoot();
    }

}
