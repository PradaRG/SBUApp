package pasantia.sbu.utn.sbu_app_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_autogestion.*
import kotlinx.android.synthetic.main.activity_autogestion.webview
import kotlinx.android.synthetic.main.activity_calendario.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.net.MalformedURLException
import java.util.regex.Pattern

class calendario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainLayout = layoutInflater.inflate(R.layout.activity_calendario, null)
        setContentView(mainLayout)
        setTitle(R.string.app_name )
        mainLayout.boton_menu.setOnClickListener {
            showBottomSheet()
        }
        webview.webChromeClient = object  : WebChromeClient(){}
        webview.webViewClient = object : WebViewClient() {}
        //webview. ("<iframe src=\\\\\"https://calendar.google.com/calendar/embed?height=600&amp;wkst=1&amp;bgcolor=%23ffffff&amp;ctz=America%2FArgentina%2FBuenos_Aires&amp;src=cHJhZGFyZ0BnbWFpbC5jb20&amp;src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&amp;src=ZW50cmVpbmFkaXJpb3NAZ21haWwuY29t&amp;src=ZXMuYXIjaG9saWRheUBncm91cC52LmNhbGVuZGFyLmdvb2dsZS5jb20&amp;color=%23039BE5&amp;color=%237986CB&amp;color=%23009688&amp;color=%23009688&amp;showTitle=0&amp;showNav=0&amp;showDate=0&amp;showPrint=0&amp;showTabs=0&amp;showCalendars=0&amp;showTz=0\\\" style=\\\"border-width:0\\\" width=\\\"800\\\" height=\\\"600\\\" frameborder=\\\"0\\\" scrolling=\\\"no\\\"></iframe>",  "text/html","utf-8")
        webview.loadUrl("https://calendar.google.com/calendar/embed?src=totoelguan%40gmail.com&ctz=America%2FArgentina%2FCordoba")
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
