package com.example.myshoestore.screens.welcomeScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myshoestore.R
import com.example.myshoestore.databinding.WelcomeScreenFragmentBinding

class WelcomeScreenFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeScreenFragment()
    }

    private lateinit var viewModel: WelcomeScreenViewModel

    private lateinit var binding: WelcomeScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_screen_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(WelcomeScreenViewModel::class.java)

        binding.welcomeScreenViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}