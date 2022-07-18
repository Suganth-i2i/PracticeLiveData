package com.example.praticelivedata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.praticelivedata.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        clickListeners()
    }

    private fun clickListeners() {
        binding.btnInc.setOnClickListener {
            viewModel.incCount()
        }

        binding.btnDec.setOnClickListener{
            viewModel.decCount()
        }
    }

    private fun initView() {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.counterFrame, CounterFragment())
        fragment.commit()

    }

}