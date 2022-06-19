package com.example.assignment.ui.workManager

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.databinding.ActivityWorkManagerBinding

class WorkManagerActivity : AppCompatActivity() {
    lateinit var binding: ActivityWorkManagerBinding
    private val viewModel: WorkManagerViewModel by viewModels{ WorkManagerViewModel.WorkManagerViewModelFactory(application) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startWorker.setOnClickListener { viewModel.startWorker() }
        binding.cancelWorker.setOnClickListener { viewModel.cancelWorker() }
    }
}