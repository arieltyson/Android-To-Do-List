package com.arieljtyson.androidtasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arieljtyson.androidtasks.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.addTodoBtn
//import kotlinx.android.synthetic.main.activity_main.deleteTodoBtn
//import kotlinx.android.synthetic.main.activity_main.etTodoTitle
//import kotlinx.android.synthetic.main.activity_main.rvTodoItems

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter(mutableListOf())

        binding.rvTodoItems.adapter = todoAdapter
        binding.rvTodoItems.layoutManager = LinearLayoutManager(this)

        binding.addTodoBtn.setOnClickListener {
            val todoTitle = binding.etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                binding.etTodoTitle.text.clear()
            }
        }

        binding.deleteTodoBtn.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}