package com.farwah.daggerhiltexample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.farwah.daggerhiltexample.adaptor.ProductListAdaptor
import com.farwah.daggerhiltexample.databinding.ActivityMainBinding
import com.farwah.daggerhiltexample.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val _binding get() = binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        //supportActionBar!!.title="Product List"
        val viewModel: MyViewModel by viewModels()
        Log.d("MainActivity" ,"this is it $viewModel")

        viewModel.getProductViewModel()
        viewModel.productList.observe(this, Observer {
            binding.recyclerView.layoutManager=
                LinearLayoutManager(this)
            binding.recyclerView.adapter= ProductListAdaptor(it.body()!!)

        })

    }
    }


