package com.example.myshoestore.screens.shoesList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.myshoestore.R
import com.example.myshoestore.ShoeActivityViewModel
import com.example.myshoestore.databinding.ShoesListFragmentBinding

class ShoesListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoesListFragment()
    }

    private lateinit var viewModel: ShoeActivityViewModel

    private lateinit var binding: ShoesListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoes_list_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeActivityViewModel::class.java)

        binding.shoesListViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoeRepository.observe(viewLifecycleOwner, Observer {
            //observe list changes
        })

        //Navigation
        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_shoesDetailFragment)
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}