package com.example.tp3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.fragment_detail.*

class details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val details = intent.getSerializableExtra("details") as Livre
        dnom.text = details.nom
        dprenom.text = details.prenom
        dtelephone.text = details.numero
        dspecialite.text = details.specialite
        dexp.text = details.nbrAnnee
        dimage.setImageResource(details.image)
        dfacebook.text="Facebook Url"
        dfacebook.setOnClickListener{
                val url = details.url
                val intent3= Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent3)
            }
        }

    }

