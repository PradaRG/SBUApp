package pasantia.sbu.utn.sbu_app_test

import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.os.Bundle
import android.content.Intent

import kotlinx.android.synthetic.main.activity_item_bottom_sheet_menu.view.*


class BottomSheetMenuAdapter(private val items: List<BottomSheetMenuItem>) : RecyclerView.Adapter<BottomSheetMenuAdapter.BottomSheetMenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetMenuViewHolder {
        return BottomSheetMenuViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.activity_item_bottom_sheet_menu, parent, false))
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: BottomSheetMenuViewHolder, position: Int) {
        holder.bind(items[position])
    }
    class BottomSheetMenuViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: BottomSheetMenuItem) {
            with(view) {
                bottom_menu_title.text = item.title
                bottom_menu_desc.text = item.description
                bottom_menu_icon.setImageResource(item.resId)
                setOnClickListener {
                    //item.action()
                    when(item.numid){
                        1->{val abrirgestion =  Intent (view.context,calendario::class.java)
                            view.context.startActivity(abrirgestion)}
                        2->{val abrirgestion =  Intent (view.context,Autogestion::class.java)
                        view.context.startActivity(abrirgestion)}
                        3->{val abrirgestion =  Intent (view.context,campus::class.java)
                            view.context.startActivity(abrirgestion)}
                    }

                    Toast.makeText(this.context, "Item with label '" + item.title + "' clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}