package com.example.kotlinflow.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinflow.databinding.FragmentHomeBinding
import java.lang.Integer.parseInt

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.numberSeq2.forEach {
//            Log.d("hello", "Sequence $it")
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow.collect {
//                delay(1000) // show after add another 1s here
//                Log.d("hello", "Hello 1st flow $it")
//            }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow.collect {
//                Log.d("hello", "Hello 2nd collector: $it")
//            }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow.buffer().collect {
//                delay(1000) // show same as add another 1s here
//                Log.d("hello", "Hello 1st flow $it")
//            }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow
//                .filter { it and 1 == 0 } // 0 is even, 1 is odd
//                .map { it * 2 } // the original value * 2
//                .collect {
//                    delay(1000)
//                    Log.d("hello", "Hello 1st flow $it")
//                }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.firstFlow.collect {
//                binding.tvFlow.text = it.toString()
//            }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.getCountDownTimer(10)
//                .catch { Log.d("hello", "Exception") } // throw the error and stop emitting
//                .collect {
//                binding.tvFlow.text = it.toString()
//            }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.secondFlow.onEach {
//                Log.d("hello", "Hello from onEach $it")
//            }
//        }

//        lifecycleScope.launchWhenResumed {
//            viewModel.getCountDownTimer(10).asLiveData().observe(viewLifecycleOwner) {
//                Log.d("hello", "Hello from asLiveData $it")
//            }
//        }

        binding.btnStart.setOnClickListener {
            startTimer()
        }

    }

    private fun startTimer() {
        try {
            val minute = parseInt(binding.etMinute.text.toString())
            val second = parseInt(binding.etSecond.text.toString())
//            lifecycleScope.launchWhenResumed {
//                viewModel.getCountDownTimer(minute, second).collect {
//                    binding.tvFlow.text = it
//                }
//            }
            val action = HomeFragmentDirections.actionHomeFragmentToCountDownFragment(minute, second)
            NavHostFragment.findNavController(this).navigate(action)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Invalid input", Toast.LENGTH_SHORT).show()
        }
    }

}