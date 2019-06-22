package pasantia.sbu.utn.sbu_app_test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_autogestion.*
import kotlinx.android.synthetic.main.activity_item_bottom_sheet_menu.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.webview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainLayout = layoutInflater.inflate(R.layout.activity_main, null)
        setContentView(mainLayout)
        setTitle(R.string.app_name )
        mainLayout.boton_menu.setOnClickListener {
            showBottomSheet()
        }
        //config webviw prueba
        webview.webChromeClient = object  : WebChromeClient(){}
        webview.webViewClient = object : WebViewClient() {}
        webview.loadUrl("https://m.facebook.com/SBUUTN")
        val settings = webview.settings
        settings.javaScriptEnabled = true
    }
    private fun getToken(){
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    var w: Int = Log.w(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                // Log and toast
                val msg = getString(R.string.msg_token_fmt, token)
                Log.d(TAG, msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            })
    }
    private fun showBottomSheet() {
        val items = arrayListOf(

            BottomSheetMenuItem(R.drawable.calendar, "Calendario Academico", "Muestra todas las fechas importantes para los alumnos",1, {}),
            BottomSheetMenuItem(R.drawable.teacup, "Autogestion", "Podras, consultar tu estado academico e inscribirte en materias y examenes ",2, {}),
            BottomSheetMenuItem(R.drawable.campusvirtual, "Campus virtual", "Podras trabajar en el campus virtual",3, {}),
            BottomSheetMenuItem(R.drawable.noticias, "Noticias", "Noticias y novedades en la facultad",4, {}),
            BottomSheetMenuItem(R.drawable.ofertaacademica, "Oferta academica", "Podras que oferta academica tiene la facultad",5, {}),
            BottomSheetMenuItem(R.drawable.asistenciadocente, "Asistencia docente", "Podras saber que docente esta dentro de la facultad",6, {}),
            BottomSheetMenuItem(R.drawable.reglamento, "Reglamento", "mira el reglamento que debes cumplir",7, {})

        )
        BottomSheetMenu(this, items).show()
    }
}
