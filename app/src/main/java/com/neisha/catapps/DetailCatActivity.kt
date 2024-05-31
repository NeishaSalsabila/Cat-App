package com.neisha.catapps

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailCatActivity : AppCompatActivity() {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_cat)

        imgPhoto = findViewById(R.id.detail_img_item_photo)
        tvName = findViewById(R.id.detail_tv_item_name)
        tvDescription = findViewById(R.id.detail_tv_item_description)

        val btnShare: ImageButton = findViewById(R.id.btn_share)
        btnShare.setOnClickListener {
            onShareButtonClick()
        }

        val cat: Cat? = intent.getParcelableExtra("cat_data")

        if (cat != null) {
            Glide.with(this)
                .load(cat.photo)
                .into(imgPhoto)

            tvName.text = cat.name
            tvDescription.text = cat.description
        } else {
            finish()
        }
    }

    private fun onShareButtonClick() {
        val cat: Cat? = intent.getParcelableExtra("cat_data")

        if (cat != null) {
            val shareText = "Check out this adorable cat: ${cat.name}\n\n${cat.description}"

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}