package pasantia.sbu.utn.sbu_app_test

data class BottomSheetMenuItem(
    val resId: Int,
    val title: String,
    val description: String,
    val numid: Int,
    val action: () -> Unit
)