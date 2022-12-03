package org.com.testing.with.simpletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import org.com.testing.with.simpletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        mainViewModel = ViewModelProviders.of(this, defaultViewModelProviderFactory)[MainViewModel::class.java]

        mainViewModel?.data?.observe(this) {
            binding.rvAdapter = RVCustomAdapter(it)
        }

    }

}