package com.example.recyclerviewapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var todoList= mutableListOf(
            Todo("work on project",true),
            Todo("try to solve admin bug",false)
        )

        val adapter=TodoAdapter(todoList)
        val rvTodos:RecyclerView=findViewById(R.id.rvTodos)
        val Addbtn: Button =findViewById(R.id.Addbtn)
        val etTodo:EditText=findViewById(R.id.etTodo)
        rvTodos.adapter=adapter
        rvTodos.layoutManager= LinearLayoutManager(this)

        Addbtn.setOnClickListener{
            val title=etTodo.text.toString()
            val todo=Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}