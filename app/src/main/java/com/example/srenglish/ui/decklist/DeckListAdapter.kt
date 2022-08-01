package com.example.srenglish.ui.decklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.srenglish.R
import com.example.srenglish.data.db.entity.DeckEntity
import kotlinx.android.synthetic.main.deck_item.view.*

class DeckListAdapter(
    private val decks: List<DeckEntity>
) : RecyclerView.Adapter<DeckListAdapter.DeckListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeckListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deck_item, parent, false)

        return DeckListViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeckListViewHolder, position: Int) {
        holder.bindView(decks[position])
    }

    override fun getItemCount() = decks.size

    class DeckListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewDeckName: TextView = itemView.text_deck_name
        private val textViewDeckWordsCount: TextView = itemView.text_deck_words_count

        fun bindView(deck: DeckEntity) {
            textViewDeckName.text = deck.name

            // TODO: get words count from db
            textViewDeckWordsCount.text = "1"
        }
    }
}