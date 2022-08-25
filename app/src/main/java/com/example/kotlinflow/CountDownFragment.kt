package com.example.kotlinflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.kotlinflow.databinding.FragmentCountDownBinding
import com.example.kotlinflow.home.HomeFragment
import com.example.kotlinflow.home.HomeViewModel

class CountDownFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    lateinit var binding: FragmentCountDownBinding
    val args: CountDownFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountDownBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            viewModel.getCountDownTimer(args.minute, args.second).collect {
                binding.tvCountDown.text = it
            }
        }
    }
}