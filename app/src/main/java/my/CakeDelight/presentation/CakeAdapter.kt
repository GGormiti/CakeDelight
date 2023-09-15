package my.CakeDelight.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dagger.hilt.android.internal.managers.ViewComponentManager
import my.CakeDelight.R
import my.CakeDelight.data.Cake
import my.CakeDelight.databinding.CakeItemBinding

class CakeAdapter :
    RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {

    private var listCake: List<Cake>? = null

    fun setListCake(listCake: List<Cake>?) {
        this.listCake = listCake
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CakeItemBinding.inflate(inflater, parent, false)

        return CakeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (listCake?.size == null) 1 else listCake?.size!!
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        holder.bind(listCake?.get(position))

    }

    class CakeViewHolder(binding: CakeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val text = binding.text
        private val photo = binding.imageCake

        fun bind(cake: Cake?) {
            text.text = cake?.name
            Glide.with(photo).load(cake?.photo).into(photo)

            itemView.setOnClickListener {
                val activity: AppCompatActivity = activityContext() as AppCompatActivity
                val cakeInfoFragment = CakesInfoFragment(cake!!)
                activity.supportFragmentManager.beginTransaction().addToBackStack(null)
                    .replace(R.id.rec, cakeInfoFragment).commit()
            }
        }

        private fun activityContext(): Context? {
            val context = itemView.context
            return if (context is ViewComponentManager.FragmentContextWrapper) {
                context.baseContext
            } else context
        }

    }
}