package com.neisha.catapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCats: RecyclerView
    private val list = ArrayList<Cat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCats = findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)

        list.addAll(listCats)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                openAboutActivity()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openAboutActivity() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private val listCats: ArrayList<Cat>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listCat = ArrayList<Cat>()
            for (i in dataName.indices) {
                val cat = Cat(dataName[i], dataDescription[i], dataPhoto[i])
                listCat.add(cat)
            }
            return listCat
        }

    private fun showRecyclerList() {
        rvCats.layoutManager = LinearLayoutManager(this)
        val listCatAdapter = ListCatAdapter(list)
        rvCats.adapter = listCatAdapter
    }
}