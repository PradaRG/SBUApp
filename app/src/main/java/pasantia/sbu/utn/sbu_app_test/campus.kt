package pasantia.sbu.utn.sbu_app_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_autogestion.*
import kotlinx.android.synthetic.main.activity_main.view.*

class campus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainLayout = layoutInflater.inflate(R.layout.activity_campus, null)
        setContentView(mainLayout)
        setTitle(R.string.app_name )
        mainLayout.boton_menu.setOnClickListener {
            showBottomSheet()
        }
        webview.webChromeClient = object  : WebChromeClient(){}
        webview.webViewClient = object : WebViewClient() {}
        webview.loadUrl("http://frp.cvg.utn.edu.ar/")
        val settings = webview.settings
        settings.javaScriptEnabled = true
//la parte del menu

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