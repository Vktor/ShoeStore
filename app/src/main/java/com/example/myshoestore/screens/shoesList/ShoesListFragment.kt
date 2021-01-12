package com.example.myshoestore.screens.shoesList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myshoestore.R
import com.example.myshoestore.databinding.ShoesListFragmentBinding

class ShoesListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoesListFragment()
    }

    private lateinit var viewModel: ShoesListViewModel

    private lateinit var binding: ShoesListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoes_list_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoesListViewModel::class.java)

        binding.shoesListViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}