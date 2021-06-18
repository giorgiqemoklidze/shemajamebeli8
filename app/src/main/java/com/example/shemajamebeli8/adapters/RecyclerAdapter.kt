package com.example.shemajamebeli8.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli8.databinding.RecyclerLayoutBinding
import com.example.shemajamebeli8.models.Summary


class RecyclerAdapter():RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

   private var summeries = mutableListOf<Summary>()

   inner class ViewHolder( val binding : RecyclerLayoutBinding):RecyclerView.ViewHolder(binding.root){

       private lateinit var fisrtTeamAdapter : FirstTeamRecyclerAdapter
       private  lateinit var SecondTeamAdapter : SecondTeamRecyclerAdapter

       fun bind(){
           initFirstRecycler()
           initSecondRecycler()
       }
       fun initFirstRecycler(){
           fisrtTeamAdapter = FirstTeamRecyclerAdapter(summeries[adapterPosition])
           binding.firstTeamRecycler.layoutManager = LinearLayoutManager(binding.root.context)
           binding.firstTeamRecycler.adapter = fisrtTeamAdapter
       }
       fun initSecondRecycler(){

           SecondTeamAdapter = SecondTeamRecyclerAdapter(summeries[adapterPosition])
           binding.SecondTeamRecycler.layoutManager = LinearLayoutManager(binding.root.context)
           binding.SecondTeamRecycler.adapter = SecondTeamAdapter
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                RecyclerLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=summeries.size

    fun getSummeries(summeries: List<Summary>){
        this.summeries = summeries as MutableList<Summary>
        notifyDataSetChanged()
    }
}