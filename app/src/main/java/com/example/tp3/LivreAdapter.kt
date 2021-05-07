package com.example.tp3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class LivreAdapter(val context: Context, var data:List<Livre>): RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.element, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(data[position].image)
        holder.nom.text = data[position].nom
        holder.prenom.text = data[position].prenom
        holder.numero.text = data[position].numero
        holder.specialite.text = data[position].specialite
        holder.map.setOnClickListener{
            val geoLocation = Uri.parse("geo:${data[position].latitute},${data[position].longitude}")
            val intent2=Intent(Intent.ACTION_VIEW,geoLocation)
            if(intent2.resolveActivity(context.packageManager)!=null) {
                context.startActivity(intent2)
            }
        }

        holder.numero.setOnClickListener{
            val uri= Uri.parse("tel:${data[position].numero}")
            val intent1=Intent(Intent.ACTION_DIAL,uri)
            if(intent1.resolveActivity(context.packageManager)!=null) {
                context.startActivity(intent1)
            }
        }

        holder.itemView.setOnClickListener{

            if(isTwoPane()) {
                val activity = context as Activity
                val dnom = activity.findViewById(R.id.dnom) as TextView
                val dprenom = activity.findViewById(R.id.dprenom) as TextView
                val dtelephone = activity.findViewById(R.id.dtelephone) as TextView
                val dspecialite = activity.findViewById(R.id.dspecialite) as TextView
                val dexp = activity.findViewById(R.id.dexp) as TextView
                val dfacebook = activity.findViewById(R.id.dfacebook) as TextView
                val dimage = activity.findViewById(R.id.dimage) as ImageView

                dnom.text = data[position].nom
                dprenom.text = data[position].prenom
                dtelephone.text = data[position].numero
                dspecialite.text = data[position].specialite
                dexp.text = data[position].nbrAnnee

                dimage.setImageResource(data[position].image)
                dfacebook.text="Facebook Url"
                dfacebook.setOnClickListener{
                    val url = data[position].url
                    val intent3= Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent3)
                }
            }
            else {
                val intent = Intent(context,details::class.java)
                intent.putExtra("details",data[position])
                context.startActivity(intent)

            }

        }



    }

    override fun getItemCount() = data.size

    private fun isTwoPane():Boolean{
        val activity = context as Activity
        return activity.findViewById<View>(R.id.fragment4)!=null
    }
}





class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val image = view.findViewById<ImageView>(R.id.imageViewLivre)
    val nom = view.findViewById<TextView>(R.id.textViewNom)
    val prenom = view.findViewById<TextView>(R.id.textViewPrenom)
    val numero = view.findViewById<TextView>(R.id.textViewTelephone)
    val specialite = view.findViewById<TextView>(R.id.textViewSpecialite)
    val map = view.findViewById<ImageView>(R.id.imageMap)
}