package com.example.recyclerview

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R.id.recyclerview

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var mWordList = LinkedList<String>()
    private lateinit var mAdapter:WordListAdapater
     lateinit var mRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var wordVM = ViewModelProviders.of(this).get(WordViewModel::class.java)


        mRecyclerView = findViewById(recyclerview)
        mWordList = wordVM.getWordList()!!;
        mAdapter = WordListAdapater(this, mWordList)
        mRecyclerView.setAdapter(mAdapter)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))

        fab.setOnClickListener { view ->

            var wordListSize = mWordList.size;
            wordVM.addWord("Word "+ wordListSize);
            mRecyclerView.getAdapter()?.notifyItemInserted(wordListSize);
            mRecyclerView.smoothScrollToPosition(wordListSize)
            Snackbar.make(view, "Word "+ wordListSize+" was added", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
