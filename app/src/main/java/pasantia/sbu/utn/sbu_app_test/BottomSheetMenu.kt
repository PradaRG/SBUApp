package pasantia.sbu.utn.sbu_app_test


import android.content.Context
import android.support.design.widget.BottomSheetDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_layout_bottomsheet.view.*
class BottomSheetMenu(private val context: Context,
                      private val items: List<BottomSheetMenuItem>) {
    private val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context)
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_layout_bottomsheet, null)
        bottomSheetDialog.setContentView(view)
        with(view) {
            bottom_sheet_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            bottom_sheet_recycler.adapter = BottomSheetMenuAdapter(items)
        }
    }
    fun show() {
        bottomSheetDialog.show()
    }
}