package com.example.praticelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.praticelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        clickListeners()
    }

    private fun clickListeners() {
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
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