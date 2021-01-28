package com.example.myshoestore.screens.shoesDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.myshoestore.R
import com.example.myshoestore.ShoeActivityViewModel
import com.example.myshoestore.databinding.ShoesDetailFragmentBinding
import com.example.myshoestore.databinding.ShoesListFragmentBinding
import com.example.myshoestore.model.Shoe

class ShoesDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ShoesDetailFragment()
    }

    private lateinit var viewModel: ShoeActivityViewModel

    private lateinit var binding: ShoesDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoes_detail_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeActivityViewModel::class.java)

        binding.shoesDetailViewModel = viewModel
        binding.lifecycleOwner = this

        //Navigation
        binding.btnSave.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoesDetailFragment_to_shoesListFragment)
            viewModel.addNewShoe(Shoe(
                viewModel.addNewId(),
                binding.editTextShoesName.text.toString(),
                binding.editTextCompanyName.text.toString(),
                binding.editTextShoesSize.text.toString().toDouble(),
                binding.editTextTextMultiLine.text.toString()
            ))
        }
        binding.btnCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoesDetailFragment_to_shoesListFragment)
        )

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}