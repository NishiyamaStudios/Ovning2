package se.nishiyamastudios.pia11ovning2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val itemText: TextView

        init {

            itemText = view.findViewById(R.id.itemTextTV)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_start, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val newPosition = position+1
        holder.itemText.text = "Item " + newPosition.toString()

        holder.itemText.setOnClickListener {

            val activity  = it.context as? AppCompatActivity

            if (activity != null) {

                activity.supportFragmentManager.beginTransaction()
                    .add(R.id.itemCon, DetailFragment())
                    .addToBackStack(null).commit()

            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }

}