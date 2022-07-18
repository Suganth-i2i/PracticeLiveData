package com.example.praticelivedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.praticelivedata.databinding.FragmentCounterBinding
import kotlinx.coroutines.CoroutineScope

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private val viewModel: CounterViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCounterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachObservers()
    }

    private fun attachObservers() {
        viewModel.getCount().observe(viewLifecycleOwner) {
            binding.txtCounter.text = it.toString()
        }
    }
}