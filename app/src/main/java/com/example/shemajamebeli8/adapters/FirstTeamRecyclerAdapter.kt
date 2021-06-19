package com.example.shemajamebeli8.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.shemajamebeli8.R
import com.example.shemajamebeli8.databinding.FirstTeamBinding
import com.example.shemajamebeli8.models.Summary


class FirstTeamRecyclerAdapter(val summary: Summary):RecyclerView.Adapter<FirstTeamRecyclerAdapter.ViewHolder>() {



    inner class ViewHolder(val binding : FirstTeamBinding): RecyclerView.ViewHolder(binding.root){



        fun bind(){


                binding.player.text = summary.team1Action?.get(adapterPosition)?.action?.player1?.playerName.toString()
                binding.player2.text = " "
                binding.time.text = summary.actionTime.toString()


            when(summary.team1Action?.get(adapterPosition)?.actionType){

                1->{
                        binding.goalType.text  = "Goals By"
                        glide(summary.team1Action[adapterPosition].action?.player1?.playerImage.toString(),binding.image)
                        if (summary.team1Action[adapterPosition].action?.goalType == 1){
                            binding.raxdeba.setImageResource(R.drawable.ic_goal)
                        }else if(summary.team1Action[adapterPosition].action?.goalType == 2){
                            binding.raxdeba.setImageResource(R.drawable.ic_autogoal)
                        }

                }

                2->{
                        binding.goalType.text  = "Yellow_Card"
                        binding.raxdeba.setImageResource(R.drawable.ic_yellow_card)
                        glide(summary.team1Action[adapterPosition].action?.player1?.playerImage.toString(),binding.image)

                }

                3->{
                        binding.goalType.text = "Red_Card"
                        glide(summary.team1Action[adapterPosition].action?.player1?.playerImage.toString(),binding.image)
                        binding.raxdeba.setImageResource(R.drawable.ic_red_card)

                }

                4-> {
                        binding.player2.text = summary.team1Action[adapterPosition].action?.player2?.playerName.toString()
                        binding.goalType.text = "Subtition"
                        glide(summary.team1Action[adapterPosition].action?.player1?.playerImage.toString(),binding.image)
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
                FirstTeamBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind()
    }

    override fun getItemCount()= summary.team1Action?.size?:0
}