package com.example.myshoestore.screens.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.myshoestore.R
import com.example.myshoestore.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*
import timber.log.Timber

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        setHasOptionsMenu(true) //need this to get the menu


        //button navigation
        binding.btnLogin.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeScreenFragment)
            Timber.i("Hola soy el signIn")
        }
        binding.btnSignUp.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeScreenFragment)
            Timber.i("Hola soy el signUp")
        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    //need this to get the menu on fragments
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }
}