package com.example.mmoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.mmoapp.core.BaseAdapter
import com.example.mmoapp.core.MMOApp
import com.example.mmoapp.core.Retry
import com.example.mmoapp.presentation.GameListAdapter
import com.example.mmoapp.presentation.GameListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: GameListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as MMOApp).gameListViewModel
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = GameListAdapter(
            object : Retry {
                override fun tryAgain() = viewModel.fetchGamesList()
            })
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        viewModel.observer(this) {
            adapter.update(it)
        }
        viewModel.fetchGamesList()
    }
}