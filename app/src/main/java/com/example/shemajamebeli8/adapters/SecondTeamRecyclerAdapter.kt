package com.example.shemajamebeli8.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.shemajamebeli8.R
import com.example.shemajamebeli8.databinding.SecondTeamBinding
import com.example.shemajamebeli8.models.Summary

class SecondTeamRecyclerAdapter(val summary: Summary):RecyclerView.Adapter<SecondTeamRecyclerAdapter.ViewHolder>() {

    private var size =1

    inner class ViewHolder(val binding : SecondTeamBinding): RecyclerView.ViewHolder(binding.root){

       fun  bind(){

           if (!summary.team2Action.isNullOrEmpty()){
              size = summary.team2Action.size
           }else {

               binding.player.text = " "
               binding.player2.text = " "
               binding.time.text = " "
               binding.goalType.text = " "
           }

           when(summary.team2Action?.get(adapterPosition)?.actionType) {
               1 -> {
                   if (!summary.team2Action[adapterPosition].action?.player1?.playerName.isNullOrBlank()) {
                       binding.player.text = summary.team2Action[adapterPosition].action?.player1?.playerName.toString()
                       binding.player2.text = " "
                       binding.time.text = summary.actionTime.toString()
                       glide(summary.team2Action[adapterPosition].action?.player1?.playerImage.toString(), binding.image)
                       binding.goalType.text = "Goals By"
                       if (summary.team2Action[adapterPosition].action?.goalType == 1) {
                           binding.raxdeba.setImageResource(R.drawable.ic_goal)
                       } else if (summary.team2Action[adapterPosition].action?.goalType == 2) {
                           binding.raxdeba.setImageResource(R.drawable.ic_autogoal)
                       }
                   }
               }
               2 -> {
                   if (!summary.team2Action[adapterPosition].action?.player1?.playerName.isNullOrBlank()) {
                       binding.player.text = summary.team2Action[adapterPosition].action?.player1?.playerName.toString()
                       binding.player2.text = " "
                       binding.time.text = summary.actionTime.toString()
                       binding.goalType.text = "Yellow_Card"
                       glide(summary.team2Action[adapterPosition].action?.player1?.playerImage.toString(), binding.image)
                       binding.raxdeba.setImageResource(R.drawable.ic_yellow_card)
                   }
               }
               3 -> {
                   if (!summary.team2Action[adapterPosition].action?.player1?.playerName.isNullOrBlank()) {
                       binding.player.text = summary.team2Action[adapterPosition].action?.player1?.playerName.toString()
                       binding.player2.text = " "
                       binding.time.text = summary.actionTime.toString()
                       binding.goalType.text = "Red_Card"
                       glide(summary.team2Action[adapterPosition].action?.player1?.playerImage.toString(), binding.image)
                       binding.raxdeba.setImageResource(R.drawable.ic_red_card)
                   }
               }

               4 -> {
                   if (!summary.team2Action[adapterPosition].action?.player1?.playerName.isNullOrBlank()) {
                       binding.player.text = summary.team2Action[adapterPosition].action?.player1?.playerName.toString()
                       binding.player2.text = summary.team2Action[adapterPosition].action?.player2?.playerName.toString()
                       binding.time.text = summary.actionTime.toString()
                       binding.goalType.text = "Subtition"
                       glide(summary.team2Action[adapterPosition].action?.player2?.playerImage.toString(), binding.image)
                   }
               }

           }

       }

        private fun glide(url:String,image : ImageView){
            Glide.with(binding.root.context)
                    .load(url).apply(RequestOptions.circleCropTransform()).placeholder(R.drawable.placeholder)
                    .into(image)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                SecondTeamBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=size
}