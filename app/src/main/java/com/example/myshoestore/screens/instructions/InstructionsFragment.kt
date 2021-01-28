package com.example.myshoestore.screens.instructions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.myshoestore.R
import com.example.myshoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    companion object {
        fun newInstance() = InstructionsFragment()
    }

    private lateinit var viewModel: InstructionsViewModel

    private lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instructions_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)

        binding.instructionsViewModel = viewModel
        binding.lifecycleOwner = this


        //Navigation
        binding.button.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoesListFragment)
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}