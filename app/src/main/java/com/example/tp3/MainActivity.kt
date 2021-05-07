package com.example.tp3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val data =loadLivre()
        recyclerView.adapter = LivreAdapter(this, loadLivre())

        if(findViewById<View>(R.id.fragment4)!=null)
        {
            val dnom = findViewById(R.id.dnom) as TextView
            val dprenom = findViewById(R.id.dprenom) as TextView
            val dtelephone = findViewById(R.id.dtelephone) as TextView
            val dspecialite =findViewById(R.id.dspecialite) as TextView
            val dexp = findViewById(R.id.dexp) as TextView
            val dfacebook = findViewById(R.id.dfacebook) as TextView
            val dimage = findViewById(R.id.dimage) as ImageView
            dnom.setText(data[0].nom)
            dprenom.setText(data[0].prenom)
            dtelephone.setText(data[0].numero)
            dspecialite.setText(data[0].specialite)
            dexp.setText(data[0].nbrAnnee)
            dimage.setImageResource(data[0].image)
            dfacebook.text="Facebook Url"

            dfacebook.setOnClickListener{
                val url = data[0].url
                val intent3= Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent3)
            }
        }

    }
        fun loadLivre():List<Livre> {
        val data = mutableListOf<Livre>()
            data.add(Livre(R.drawable.Livre,"La rose de blida","En sortant de la prison de l'école militaire, le petit Mohammed croise une belle et mystérieuse jeune femme dont il tombe éperduement amoureux","9782218948701","yasmina khadra","https://www.facebook.com/larosedeblida","2009",36.753769,3.058756))
            data.add(Livre(R.drawable.Livre,"La rose de blida","En sortant de la prison de l'école militaire, le petit Mohammed croise une belle et mystérieuse jeune femme dont il tombe éperduement amoureux","9782218948701","yasmina khadra","https://www.facebook.com/larosedeblida","2009",36.753769,3.058756))
            data.add(Livre(R.drawable.Livre,"La rose de blida","En sortant de la prison de l'école militaire, le petit Mohammed croise une belle et mystérieuse jeune femme dont il tombe éperduement amoureux","9782218948701","yasmina khadra","https://www.facebook.com/larosedeblida","2009",36.753769,3.058756))
            data.add(Livre(R.drawable.Livre,"La rose de blida","En sortant de la prison de l'école militaire, le petit Mohammed croise une belle et mystérieuse jeune femme dont il tombe éperduement amoureux","9782218948701","yasmina khadra","https://www.facebook.com/larosedeblida","2009",36.753769,3.058756))
            return data
    }
}